package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.BancaModel;
import br.com.dbug.questlab.repository.BancaRepository;
import br.com.dbug.questlab.rest.dto.BancaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BancaService {

    @Autowired
    private BancaRepository bancaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public BancaDTO obterPorId(int id){
        BancaModel bancaModel = bancaRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Banca com ID "+ id +" não encontrada."));
        return modelMapper.map(bancaModel, BancaDTO.class);
    }

    @Transactional(readOnly = true)
    public List<BancaDTO> obterTodos() {
        List<BancaModel> bancas = bancaRepository.findAll();
        return bancas.stream()
                .map(banca -> modelMapper.map(banca, BancaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public BancaDTO salvar(BancaModel novaBanca) {
        try {

            if (bancaRepository.existsByCnpj(novaBanca.getCnpj())){
                throw new ConstraintException("Já existe uma banca com CNPJ "+ novaBanca.getCnpj() +" na base de dados.");
            }

            return modelMapper.map(bancaRepository.save(novaBanca), BancaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar a banca " + novaBanca.getRazaoSocial() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar a banca " + novaBanca.getRazaoSocial() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar a banca " + novaBanca.getRazaoSocial() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar a banca " + novaBanca.getRazaoSocial() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public BancaDTO atualizar(BancaModel bancaExistente) {
        try {
            if (!bancaRepository.existsById(bancaExistente.getId())) {
                throw new ConstraintException("Banca com esse ID " + bancaExistente.getId() + " não existe na base de dados!");
            }

            return modelMapper.map(bancaRepository.save(bancaExistente), BancaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar a banca " + bancaExistente.getRazaoSocial() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar a banca " + bancaExistente.getRazaoSocial() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar a banca " + bancaExistente.getRazaoSocial() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar a banca " + bancaExistente.getRazaoSocial() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar a banca" + bancaExistente.getRazaoSocial() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional
    public void deletar(BancaModel bancaExistente){
        try {
            if (!bancaRepository.existsById(bancaExistente.getId())) {
                throw new ConstraintException("Banca com esse ID " + bancaExistente.getId() + " não existe na base de dados!");
            }

            bancaRepository.delete(bancaExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar a banca " + bancaExistente.getRazaoSocial() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar a banca " + bancaExistente.getRazaoSocial() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar a banca " + bancaExistente.getRazaoSocial() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar a banca " + bancaExistente.getRazaoSocial() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar a banca" + bancaExistente.getRazaoSocial() + ". Não encontrada no banco de dados!");
        }
    }
}
