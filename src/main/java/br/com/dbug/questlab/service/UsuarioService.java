package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.UsuarioModel;
import br.com.dbug.questlab.repository.QuestaoRepository;
import br.com.dbug.questlab.repository.UsuarioRepository;
import br.com.dbug.questlab.repository.UsuarioRespostaRepository;
import br.com.dbug.questlab.repository.projection.RelatorioDesempenhoUsuarioProjection;
import br.com.dbug.questlab.repository.projection.RelatorioEvolucaoProjection;
import br.com.dbug.questlab.repository.projection.RelatorioUsuariosAtivosProjection;
import br.com.dbug.questlab.rest.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelas operações relacionadas aos usuários.
 */
@Service
public class UsuarioService {

    /**
     * Instância do repositório de usuários, responsável por realizar operações de
     * persistência e consulta diretamente no banco de dados.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Instância do ModelMapper gerenciada pelo SpringBoot (Singleton).
     */
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioRespostaRepository usuarioRespostaRepository;

    @Autowired
    private QuestaoRepository questaoRepository;

    /**
     * Obtém um usuário pelo ID.
     *
     * @param id ID do usuário.
     * @return usuarioDTO representando o usuário encontrado.
     * @throws ObjectNotFoundException Se o usuário não for encontrado.
     */
    @Transactional(readOnly = true)
    public UsuarioDTO obterPorId(int id) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário com ID " + id + " não encontrado."));
        return modelMapper.map(usuarioModel, UsuarioDTO.class);
    }

    /**
     * Obtém a lista de todos os usuários cadastrados.
     *
     * @return Lista de UsuarioDTO representando os usuários cadastrados.
     */
    @Transactional(readOnly = true)
    public List<UsuarioDTO> obterTodos() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Salva um novo usuários na base de dados.
     *
     * @param novoUsuario usuarioModel contendo os dados do novo usuário.
     * @return usuarioDTO representando o usuário salvo.
     * @throws ConstraintException    Se o telefone ou e-mail já existirem.
     * @throws DataIntegrityException Se ocorrer violação de integridade.
     * @throws BusinessRuleException  Se houver violação de regra de negócio.
     * @throws SQLException           Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public UsuarioDTO salvar(UsuarioModel novoUsuario) {
        try {
            //Caso ocorra uma tentativa de salvar um novo usuario com um cpf já existente.
            if (usuarioRepository.existsByCpf(novoUsuario.getCpf())) {
                throw new ConstraintException("Já existe um usuário com esse CPF " + novoUsuario.getCpf() + " na base de dados!");
            }

            return modelMapper.map(usuarioRepository.save(novoUsuario), UsuarioDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o usuário " + novoUsuario.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o usuário " + novoUsuario.getNome() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar o usuário " + novoUsuario.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar o usuário " + novoUsuario.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }

    /**
     * Atualiza os dados de um usuário existente.
     *
     * @param usuarioExistente usuarioModel contendo os dados atualizados do usuário.
     * @return usuarioDTO representando o usuário atualizado.
     * @throws ConstraintException    Se o telefone ou e-mail não existir.
     * @throws DataIntegrityException Se ocorrer violação de integridade.
     * @throws BusinessRuleException  Se houver violação de regra de negócio.
     * @throws SQLException           Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public UsuarioDTO atualizar(UsuarioModel usuarioExistente) {

        try {
            //Caso ocorra uma tentativa de atualizar um usuário que não existe utilizando um CPF.
            if (!usuarioRepository.existsByCpf(usuarioExistente.getCpf())) {
                throw new ConstraintException("O usuário com esse CPF " + usuarioExistente.getCpf() + " não existe na base de dados!");
            }

            return modelMapper.map(usuarioRepository.save(usuarioExistente), UsuarioDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o usuário " + usuarioExistente.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar o usuário " + usuarioExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o usuário " + usuarioExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o usuário " + usuarioExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o usuário" + usuarioExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }


    /**
     * Deleta um usuário da base de dados.
     *
     * @param usuarioExistente usuarioModel contendo os dados do usuário a ser deletado.
     * @throws ConstraintException    Se o usuário (id) não existir.
     * @throws DataIntegrityException Se ocorrer violação de integridade.
     * @throws BusinessRuleException  Se houver violação de regra de negócio.
     * @throws SQLException           Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public void deletar(UsuarioModel usuarioExistente) {

        try {
            //Caso ocorra uma tentativa de deletar um usuário que não existe utilizando o id.
            if (!usuarioRepository.existsById(usuarioExistente.getId())) {
                throw new ConstraintException("Usuário inexistente na base de dados!");
            }

            //Deletar o usuário na base de dados.
            usuarioRepository.delete(usuarioExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o usuário " + usuarioExistente.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar o usuário " + usuarioExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar o usuário " + usuarioExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar o usuário " + usuarioExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o usuário" + usuarioExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }

    @Transactional(readOnly = true)
    public List<RelatorioUsuarioAtivoDTO> gerarRelatorioUsuariosAtivos(int idUsuario) {
        UsuarioDTO usuarioDTO = this.obterPorId(idUsuario);
        if(!"ADMIN".equalsIgnoreCase(usuarioDTO.getPerfil())){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório.");
        }

        List<RelatorioUsuariosAtivosProjection> usuariosAtivos = usuarioRepository.findByAtivoTrue();

        return usuariosAtivos.stream()
                .map(u -> new RelatorioUsuarioAtivoDTO(
                        u.getNome(),
                        u.getEmail(),
                        u.getPerfil(),
                        u.getDataNascimento()
                ))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RelatorioDesempenhoUsuarioDTO gerarRelatorioDesempenhoUsuario(
            int idUsuarioSolicitante,
            int idUsuarioAlvo,
            LocalDate dataInicial,
            LocalDate dataFinal
    ) {
        UsuarioDTO usuarioSolicitante = this.obterPorId(idUsuarioSolicitante);
        if("PROFESSOR".equalsIgnoreCase(usuarioSolicitante.getPerfil())){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório.");
        }

        if("ALUNO".equalsIgnoreCase(usuarioSolicitante.getPerfil()) && idUsuarioSolicitante != idUsuarioAlvo){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório, ALUNO só pode visualizar os próprios dados.");
        }

        List<RelatorioDesempenhoUsuarioProjection> respostas = usuarioRespostaRepository.buscarRespostasDoUsuario(
                idUsuarioAlvo, dataInicial, dataFinal
        );

        long totalRespostas = respostas.size();

        long totalAcertos = respostas.stream()
                .filter(r -> r.getCorreta() == true)
                .count();

        long totalErros = totalRespostas - totalAcertos;

        double taxaAproveitamento = 0.0;
        if (totalRespostas > 0) {
            taxaAproveitamento = (double) totalAcertos / totalRespostas * 100.0;
        }

        return new RelatorioDesempenhoUsuarioDTO(totalRespostas, totalAcertos, totalErros, taxaAproveitamento);
    }

    @Transactional(readOnly = true)
    public RelatorioParticipacaoDTO gerarRelatorioParticipacao(
            int idUsuario,
            int mes,
            int ano
    ) {
        UsuarioDTO usuarioSolicitante = this.obterPorId(idUsuario);
        if(!"ADMIN".equalsIgnoreCase(usuarioSolicitante.getPerfil())){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório.");
        }

        LocalDate inicioMesAtual = LocalDate.of(ano, mes, 1);
        LocalDate fimMesAtual = inicioMesAtual.with(TemporalAdjusters.lastDayOfMonth());

        LocalDate inicioMesAnterior = inicioMesAtual.minusMonths(1);
        LocalDate fimMesAnterior = inicioMesAnterior.with(TemporalAdjusters.lastDayOfMonth());

        long totalUsuarios = usuarioRepository.count();
        long totalAtivos = usuarioRepository.countByAtivoTrue();
        long qtdAtual = usuarioRespostaRepository.countRespostasPorPeriodo(inicioMesAtual, fimMesAtual);
        long qtdAnterior = usuarioRespostaRepository.countRespostasPorPeriodo(inicioMesAnterior, fimMesAnterior);

        double crescimento = 0.0;
        if (qtdAnterior > 0) {
            crescimento = ((double) (qtdAtual - qtdAnterior) / qtdAnterior) * 100.0;
        } else if (qtdAtual > 0) {
            crescimento = 100.0;
        }

        return new RelatorioParticipacaoDTO(
                totalUsuarios,
                totalAtivos,
                qtdAtual,
                crescimento
        );
    }

    @Transactional(readOnly = true)
    public Page<RelatorioEvolucaoDTO> gerarRelatorioEvolucao(
            int idUsuarioSolicitante,
            int pagina,
            int tamanho
    ) {
        UsuarioDTO usuarioSolicitante = this.obterPorId(idUsuarioSolicitante);
        if(!"ALUNO".equalsIgnoreCase(usuarioSolicitante.getPerfil())){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório.");
        }

        // Ordenado pelo total de acertos para não fazer cálculo na querie
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.Direction.DESC, "totalAcertos");
        Page<RelatorioEvolucaoProjection> dadosEvolucao = usuarioRepository.buscarDadosEvolucao(idUsuarioSolicitante, pageable);

        return dadosEvolucao.map(d -> {
            RelatorioEvolucaoDTO relatorioEvolucaoDTO = new RelatorioEvolucaoDTO();
            relatorioEvolucaoDTO.setDisciplina(d.getDisciplina());
            relatorioEvolucaoDTO.setAssunto(d.getAssunto());
            relatorioEvolucaoDTO.setTotalTentativas(d.getTotalTentativas());

            double percentual = 0.0;
            if (d.getTotalTentativas() > 0) {
                percentual = (double) d.getTotalAcertos() / d.getTotalTentativas() * 100.0;
                BigDecimal bd = BigDecimal.valueOf(percentual);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                percentual = bd.doubleValue();
            }

            relatorioEvolucaoDTO.setPercentualAcertos(percentual);
            return relatorioEvolucaoDTO;
        });
    }

    @Transactional(readOnly = true)
    public RelatorioIndicadoresDTO gerarRelatorioIndicadores(int idUsuarioSolicitante){
        UsuarioDTO usuarioSolicitante = this.obterPorId(idUsuarioSolicitante);
        if(!"ADMIN".equalsIgnoreCase(usuarioSolicitante.getPerfil())){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório.");
        }

        long totalAtivos = usuarioRepository.countByAtivoTrue();
        long totalQuestoesCadastradas = questaoRepository.count();
        long totalQuestoesResolvidas = usuarioRespostaRepository.count();
        long totalAcertos = usuarioRespostaRepository.countTotalAcertos();
        long totalRespondidas = usuarioRespostaRepository.count();
        double percentual = 0.0;

        if (totalRespondidas > 0) {
            percentual = (double) totalAcertos / totalRespondidas * 100.0;
            BigDecimal bd = BigDecimal.valueOf(percentual);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            percentual = bd.doubleValue();
        }

        LocalDate anoAnterior = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        long totalAnosAnteriores = questaoRepository.countByDataCriacaoBefore(anoAnterior);

        double crescimento = 0.0;
        if (totalAnosAnteriores > 0) {
            long totalEsseAno = totalQuestoesCadastradas - totalAnosAnteriores;
            crescimento = (double) totalEsseAno / totalAnosAnteriores * 100.0;
            BigDecimal bd = BigDecimal.valueOf(crescimento);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            crescimento = bd.doubleValue();
        }

        return RelatorioIndicadoresDTO.builder()
                .dataGeracao(LocalDate.now())
                .usuario(usuarioSolicitante.getNome())
                .usuarios(new RelatorioIndicadoresDTO.SecaoUsuarios(totalAtivos))
                .bancoQuestoes(new RelatorioIndicadoresDTO.SecaoQuestoes(totalQuestoesCadastradas,totalQuestoesResolvidas))
                .desempenhoGlobal(new RelatorioIndicadoresDTO.SecaoDesempenho(percentual,crescimento))
                .build();
    }

}
