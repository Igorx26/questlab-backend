package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.UsuarioRespostaModel;
import br.com.dbug.questlab.repository.UsuarioRespostaRepository;
import br.com.dbug.questlab.rest.dto.UsuarioRespostaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioRespostaService {

    @Autowired
    private UsuarioRespostaRepository usuarioRespostaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public UsuarioRespostaDTO obterPorId(int id){
        UsuarioRespostaModel usuarioRespostaModel = usuarioRespostaRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("UsuarioResposta com ID "+ id +" não encontrada."));
        return modelMapper.map(usuarioRespostaModel, UsuarioRespostaDTO.class);
    }

    @Transactional(readOnly = true)
    public List<UsuarioRespostaDTO> obterTodos() {
        List<UsuarioRespostaModel> usuarioRespostas = usuarioRespostaRepository.findAll();
        return usuarioRespostas.stream()
                .map(usuarioResposta -> modelMapper.map(usuarioResposta, UsuarioRespostaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public UsuarioRespostaDTO salvar(UsuarioRespostaModel novaUsuarioResposta) {
        try {

            if (usuarioRespostaRepository.existsByIdUsuarioAndIdQuestao(novaUsuarioResposta.getIdUsuario(), novaUsuarioResposta.getIdQuestao())){
                throw new ConstraintException("Já existe uma resposta do usuário para a questão ID "+ novaUsuarioResposta.getIdQuestao() +" na base de dados.");
            }

            return modelMapper.map(usuarioRespostaRepository.save(novaUsuarioResposta), UsuarioRespostaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar a resposta do usuário " + novaUsuarioResposta.getId() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar a resposta do usuário " + novaUsuarioResposta.getId() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar a resposta do usuário " + novaUsuarioResposta.getId() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar a resposta do usuário " + novaUsuarioResposta.getId() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public UsuarioRespostaDTO atualizar(UsuarioRespostaModel usuarioRespostaExistente) {
        try {
            if (!usuarioRespostaRepository.existsById(usuarioRespostaExistente.getId())) {
                throw new ConstraintException("UsuarioResposta com esse ID " + usuarioRespostaExistente.getId() + " não existe na base de dados!");
            }

            return modelMapper.map(usuarioRespostaRepository.save(usuarioRespostaExistente), UsuarioRespostaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar a resposta do usuário " + usuarioRespostaExistente.getId() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar a resposta do usuário " + usuarioRespostaExistente.getId() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar a resposta do usuário " + usuarioRespostaExistente.getId() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar a resposta do usuário " + usuarioRespostaExistente.getId() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar a resposta do usuário" + usuarioRespostaExistente.getId() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional
    public void deletar(UsuarioRespostaModel usuarioRespostaExistente){
        try {
            if (!usuarioRespostaRepository.existsById(usuarioRespostaExistente.getId())) {
                throw new ConstraintException("UsuarioResposta com esse ID " + usuarioRespostaExistente.getId() + " não existe na base de dados!");
            }

            usuarioRespostaRepository.delete(usuarioRespostaExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar a resposta do usuário " + usuarioRespostaExistente.getId() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar a resposta do usuário " + usuarioRespostaExistente.getId() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar a resposta do usuário " + usuarioRespostaExistente.getId() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar a resposta do usuário " + usuarioRespostaExistente.getId() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar a resposta do usuário" + usuarioRespostaExistente.getId() + ". Não encontrada no banco de dados!");
        }
    }
}
