package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.AssuntoModel;
import br.com.dbug.questlab.repository.AssuntoRepository;
import br.com.dbug.questlab.rest.dto.AssuntoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssuntoService {

    @Autowired
    AssuntoRepository assuntoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public AssuntoDTO obterPorId(int id){
        AssuntoModel assuntoModel = assuntoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Assunto com ID "+ id +" não encontrado."));
        return modelMapper.map(assuntoModel, AssuntoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<AssuntoDTO> obterTodos() {
        List<AssuntoModel> assuntos = assuntoRepository.findAll();
        return assuntos.stream()
                .map(assunto -> modelMapper.map(assunto, AssuntoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public AssuntoDTO salvar(AssuntoModel novoAssunto) {
        try {
            if (assuntoRepository.existsByNome(novoAssunto.getNome())) {
                throw new ConstraintException("Já existe um assunto com esse nome " + novoAssunto.getNome() + " na base de dados!");
            }

            return modelMapper.map(assuntoRepository.save(novoAssunto), AssuntoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o assunto " + novoAssunto.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o assunto " + novoAssunto.getNome() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar o assunto " + novoAssunto.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar o assunto " + novoAssunto.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public AssuntoDTO atualizar(AssuntoModel assuntoExistente) {
        try {
            if (!assuntoRepository.existsById(assuntoExistente.getId())) {
                throw new ConstraintException("Assunto com esse nome " + assuntoExistente.getNome() + " não existe na base de dados!");
            }

            return modelMapper.map(assuntoRepository.save(assuntoExistente), AssuntoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o assunto " + assuntoExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar o assunto " + assuntoExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o assunto " + assuntoExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o assunto " + assuntoExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o assunto" + assuntoExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }

    @Transactional
    public void deletar(AssuntoModel assuntoExistente) {
        try {
            if (!assuntoRepository.existsById(assuntoExistente.getId())) {
                throw new ConstraintException("Assunto com esse nome " + assuntoExistente.getNome() + " não existe na base de dados!");
            }

            assuntoRepository.delete(assuntoExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o assunto " + assuntoExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar o assunto " + assuntoExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar o assunto " + assuntoExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar o assunto " + assuntoExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o assunto" + assuntoExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
}
