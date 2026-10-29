package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.InstituicaoModel;
import br.com.dbug.questlab.repository.InstituicaoRepository;
import br.com.dbug.questlab.rest.dto.InstituicaoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public InstituicaoDTO obterPorId(int id){
        InstituicaoModel instituicaoModel = instituicaoRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Instituicao com ID "+ id +" não encontrada."));
        return modelMapper.map(instituicaoModel, InstituicaoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<InstituicaoDTO> obterTodos() {
        List<InstituicaoModel> instituicoes = instituicaoRepository.findAll();
        return instituicoes.stream()
                .map(instituicao -> modelMapper.map(instituicao, InstituicaoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public InstituicaoDTO salvar(InstituicaoModel novaInstituicao) {
        try {

            if (instituicaoRepository.existsByCnpj(novaInstituicao.getCnpj())){
                throw new ConstraintException("Já existe uma instituição com o nome "+ novaInstituicao.getRazaoSocial() +" na base de dados.");
            }

            return modelMapper.map(instituicaoRepository.save(novaInstituicao), InstituicaoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar a instituição " + novaInstituicao.getRazaoSocial() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar a instituição " + novaInstituicao.getRazaoSocial() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar a instituição " + novaInstituicao.getRazaoSocial() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar a instituição " + novaInstituicao.getRazaoSocial() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public InstituicaoDTO atualizar(InstituicaoModel instituicaoExistente) {
        try {
            if (!instituicaoRepository.existsById(instituicaoExistente.getId())) {
                throw new ConstraintException("Instituição com esse ID " + instituicaoExistente.getId() + " não existe na base de dados!");
            }

            return modelMapper.map(instituicaoRepository.save(instituicaoExistente), InstituicaoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar a instituição " + instituicaoExistente.getRazaoSocial() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar a instituição " + instituicaoExistente.getRazaoSocial() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar a instituição " + instituicaoExistente.getRazaoSocial() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar a instituição " + instituicaoExistente.getRazaoSocial() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar a instituição" + instituicaoExistente.getRazaoSocial() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional
    public void deletar(InstituicaoModel instituicaoExistente){
        try {
            if (!instituicaoRepository.existsById(instituicaoExistente.getId())) {
                throw new ConstraintException("Instituição com esse ID " + instituicaoExistente.getId() + " não existe na base de dados!");
            }

            instituicaoRepository.delete(instituicaoExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar a instituição " + instituicaoExistente.getRazaoSocial() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar a instituição " + instituicaoExistente.getRazaoSocial() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar a instituição " + instituicaoExistente.getRazaoSocial() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar a instituição " + instituicaoExistente.getRazaoSocial() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar a instituição" + instituicaoExistente.getRazaoSocial() + ". Não encontrada no banco de dados!");
        }
    }
}
