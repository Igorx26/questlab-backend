package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.QuestaoModel;
import br.com.dbug.questlab.repository.QuestaoRepository;
import br.com.dbug.questlab.repository.projection.RelatorioQuestoesAnuladasProjection;
import br.com.dbug.questlab.repository.projection.RelatorioQuestoesDisciplinaProjection;
import br.com.dbug.questlab.rest.dto.QuestaoDTO;
import br.com.dbug.questlab.rest.dto.RelatorioQuestoesAnuladasDTO;
import br.com.dbug.questlab.rest.dto.RelatorioQuestoesDisciplinaDTO;
import br.com.dbug.questlab.rest.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public QuestaoDTO obterPorId(int id){
        QuestaoModel questaoModel = questaoRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Questão com ID "+ id +" não encontrada."));
        return modelMapper.map(questaoModel, QuestaoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<QuestaoDTO> obterTodos() {
        List<QuestaoModel> questoes = questaoRepository.findAll();
        return questoes.stream()
                .map(questao -> modelMapper.map(questao, QuestaoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public QuestaoDTO salvar(QuestaoModel novaQuestao) {
        try {

            if (questaoRepository.existsByEnunciado(novaQuestao.getEnunciado())){
                throw new ConstraintException("Já existe uma questão com o enunciado "+ novaQuestao.getEnunciado() +" na base de dados.");
            }

            return modelMapper.map(questaoRepository.save(novaQuestao), QuestaoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar a questão " + novaQuestao.getEnunciado() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar a questão " + novaQuestao.getEnunciado() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar a questão " + novaQuestao.getEnunciado() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar a questão " + novaQuestao.getEnunciado() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public QuestaoDTO atualizar(QuestaoModel questaoExistente) {
        try {
            if (!questaoRepository.existsById(questaoExistente.getId())) {
                throw new ConstraintException("Questão com esse ID " + questaoExistente.getId() + " não existe na base de dados!");
            }

            return modelMapper.map(questaoRepository.save(questaoExistente), QuestaoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar a questão " + questaoExistente.getEnunciado() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar a questão " + questaoExistente.getEnunciado() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar a questão " + questaoExistente.getEnunciado() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar a questão " + questaoExistente.getEnunciado() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar a questão" + questaoExistente.getEnunciado() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional
    public void deletar(QuestaoModel questaoExistente){
        try {
            if (!questaoRepository.existsById(questaoExistente.getId())) {
                throw new ConstraintException("Questão com esse ID " + questaoExistente.getId() + " não existe na base de dados!");
            }

            questaoRepository.delete(questaoExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar a questão " + questaoExistente.getEnunciado() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar a questão " + questaoExistente.getEnunciado() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar a questão " + questaoExistente.getEnunciado() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar a questão " + questaoExistente.getEnunciado() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar a questão" + questaoExistente.getEnunciado() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional(readOnly = true)
    public List<RelatorioQuestoesDisciplinaDTO> gerarRelatorioQuestoesPorDisciplina(int idUsuario) {
        UsuarioDTO usuarioDTO = usuarioService.obterPorId(idUsuario);
        if("ALUNO".equalsIgnoreCase(usuarioDTO.getPerfil())){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório.");
        }

        List<RelatorioQuestoesDisciplinaProjection> resultado = questaoRepository.buscarQuestoesPorDisciplina();

        return resultado.stream()
                .map(r -> new RelatorioQuestoesDisciplinaDTO(
                        r.getNomeDisciplina(),
                        r.getTotalQuestoes(),
                        r.getTotalAnuladas()
                ))
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public Page<RelatorioQuestoesAnuladasDTO> gerarRelatorioQuestoesAnuladasPorPeriodo(
            int idUsuario, LocalDate dataInicial, LocalDate dataFinal, int pagina, int tamanho
    ) {
        UsuarioDTO usuarioDTO = usuarioService.obterPorId(idUsuario);
        if("ALUNO".equalsIgnoreCase(usuarioDTO.getPerfil())){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório.");
        }

        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.Direction.DESC, "dataAnulacao");
        Page<RelatorioQuestoesAnuladasProjection> resultado = questaoRepository.buscarQuestoesAnuladasPorPeriodo(dataInicial, dataFinal, pageable);

        return resultado.map(r -> new RelatorioQuestoesAnuladasDTO(
                        resumirEnunciado(r.getEnunciado()),
                        r.getNomeDisciplina(),
                        r.getNomeAssunto(),
                        r.getDataAnulacao(),
                        r.getComentarioProfessor()
                ));
    }

    private String resumirEnunciado(String enunciado){
        if (enunciado == null) return "";
        return enunciado.length() > 20 ? enunciado.substring(0,20)+ "..." : enunciado;
    }
}
