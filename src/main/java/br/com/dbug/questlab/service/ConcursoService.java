package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.ConcursoModel;
import br.com.dbug.questlab.repository.ConcursoRepository;
import br.com.dbug.questlab.rest.dto.ConcursoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcursoService {
    @Autowired
    private ConcursoRepository concursoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ConcursoDTO obterPorId(int id){
        ConcursoModel concursoModel = concursoRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Concurso com ID "+ id +" não encontrado."));
        return modelMapper.map(concursoModel, ConcursoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<ConcursoDTO> obterTodos() {
        List<ConcursoModel> concursos = concursoRepository.findAll();
        return concursos.stream()
                .map(concurso -> modelMapper.map(concurso, ConcursoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public ConcursoDTO salvar(ConcursoModel novoConcurso) {
        try {

            if (concursoRepository.existsByNomeAndAno(novoConcurso.getNome(), novoConcurso.getAno())){
                throw new ConstraintException("Já existe um concurso com o nome "+ novoConcurso.getNome() +" no ano "+ novoConcurso.getAno() +" na base de dados.");
            }

            return modelMapper.map(concursoRepository.save(novoConcurso), ConcursoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o concurso " + novoConcurso.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o concurso " + novoConcurso.getNome() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar o concurso " + novoConcurso.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar o concurso " + novoConcurso.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public ConcursoDTO atualizar(ConcursoModel concursoExistente) {
        try {
            if (!concursoRepository.existsById(concursoExistente.getId())) {
                throw new ConstraintException("Concurso com esse ID " + concursoExistente.getId() + " não existe na base de dados!");
            }

            return modelMapper.map(concursoRepository.save(concursoExistente), ConcursoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o concurso " + concursoExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar o concurso " + concursoExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o concurso " + concursoExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o concurso " + concursoExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o concurso" + concursoExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }

    @Transactional
    public void deletar(ConcursoModel concursoExistente){
        try {
            if (!concursoRepository.existsById(concursoExistente.getId())) {
                throw new ConstraintException("Concurso com esse ID " + concursoExistente.getId() + " não existe na base de dados!");
            }

            concursoRepository.delete(concursoExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o concurso " + concursoExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar o concurso " + concursoExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar o concurso " + concursoExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar o concurso " + concursoExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o concurso" + concursoExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
}
