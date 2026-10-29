package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.DisciplinaModel;
import br.com.dbug.questlab.repository.DisciplinaRepository;
import br.com.dbug.questlab.repository.QuestaoRepository;
import br.com.dbug.questlab.repository.projection.RelatorioDesempenhoDisciplinaProjection;
import br.com.dbug.questlab.rest.dto.DisciplinaDTO;
import br.com.dbug.questlab.rest.dto.RelatorioDesempenhoDisciplinaDTO;
import br.com.dbug.questlab.rest.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private QuestaoRepository questaoRepository;

    @Transactional(readOnly = true)
    public DisciplinaDTO obterPorId(int id){
        DisciplinaModel disciplinaModel = disciplinaRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Disciplina com ID "+ id +" não encontrada."));
        return modelMapper.map(disciplinaModel, DisciplinaDTO.class);
    }

    @Transactional(readOnly = true)
    public List<DisciplinaDTO> obterTodos() {
        List<DisciplinaModel> disciplinas = disciplinaRepository.findAll();
        return disciplinas.stream()
                .map(disciplina -> modelMapper.map(disciplina, DisciplinaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public DisciplinaDTO salvar(DisciplinaModel novoDisciplina) {
        try {

            if (disciplinaRepository.existsByNome(novoDisciplina.getNome())){
                throw new ConstraintException("Já existe uma disciplina com o nome "+ novoDisciplina.getNome() +" na base de dados.");
            }

            return modelMapper.map(disciplinaRepository.save(novoDisciplina), DisciplinaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar a disciplina " + novoDisciplina.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar a disciplina " + novoDisciplina.getNome() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar a disciplina " + novoDisciplina.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar a disciplina " + novoDisciplina.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public DisciplinaDTO atualizar(DisciplinaModel disciplinaExistente) {
        try {
            if (!disciplinaRepository.existsById(disciplinaExistente.getId())) {
                throw new ConstraintException("Disciplina com esse ID " + disciplinaExistente.getId() + " não existe na base de dados!");
            }

            return modelMapper.map(disciplinaRepository.save(disciplinaExistente), DisciplinaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar a disciplina " + disciplinaExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar a disciplina " + disciplinaExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar a disciplina " + disciplinaExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar a disciplina " + disciplinaExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar a disciplina" + disciplinaExistente.getNome() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional
    public void deletar(DisciplinaModel disciplinaExistente){
        try {
            if (!disciplinaRepository.existsById(disciplinaExistente.getId())) {
                throw new ConstraintException("Disciplina com esse ID " + disciplinaExistente.getId() + " não existe na base de dados!");
            }

            disciplinaRepository.delete(disciplinaExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar a disciplina " + disciplinaExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar a disciplina " + disciplinaExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar a disciplina " + disciplinaExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar a disciplina " + disciplinaExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar a disciplina" + disciplinaExistente.getNome() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional(readOnly = true)
    public List<RelatorioDesempenhoDisciplinaDTO> gerarRelatorioDesempenhoDisciplina(
        int idUsuario, Integer idDisciplina, Integer idConcurso, LocalDate dataInicial, LocalDate dataFinal
    ){
        UsuarioDTO usuario = usuarioService.obterPorId(idUsuario);
        if ("ALUNO".equalsIgnoreCase(usuario.getPerfil())){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório.");
        }

        List<RelatorioDesempenhoDisciplinaProjection> dadosDesempenho =
                disciplinaRepository.buscarDadosDisciplina(idDisciplina, idConcurso, dataInicial, dataFinal);
        long qtdQuestoesAnuladas = disciplinaRepository.contarAnuladas(idDisciplina, idConcurso);

        return dadosDesempenho.stream().map(d -> {
            double mediaAcertos = 0.0;
            if (d.getTotalTentativas() > 0) {
                mediaAcertos = (double) d.getTotalAcertos() / d.getTotalTentativas() * 100.0;
            }
            BigDecimal bd = BigDecimal.valueOf(mediaAcertos);
            bd = bd.setScale(2, RoundingMode.HALF_UP);

            mediaAcertos = bd.doubleValue();

            return new RelatorioDesempenhoDisciplinaDTO(
                    d.getDisciplina(),
                    mediaAcertos,
                    d.getTotalTentativas(),
                    qtdQuestoesAnuladas
            );
        }).collect(Collectors.toList());
    }
}
