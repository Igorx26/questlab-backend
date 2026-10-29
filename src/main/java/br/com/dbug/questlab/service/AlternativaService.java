package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.AlternativaModel;
import br.com.dbug.questlab.repository.AlternativaRepository;
import br.com.dbug.questlab.rest.dto.AlternativaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlternativaService {

    @Autowired
    private AlternativaRepository alternativaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public AlternativaDTO obterPorId(int id){
        AlternativaModel alternativaModel = alternativaRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Alternativa com ID "+ id +" não encontrada."));
        return modelMapper.map(alternativaModel, AlternativaDTO.class);
    }

    @Transactional(readOnly = true)
    public List<AlternativaDTO> obterTodos() {
        List<AlternativaModel> alternativas = alternativaRepository.findAll();
        return alternativas.stream()
                .map(alternativa -> modelMapper.map(alternativa, AlternativaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public AlternativaDTO salvar(AlternativaModel novaAlternativa) {
        try {

            if (alternativaRepository.existsByTexto(novaAlternativa.getTexto())){
                throw new ConstraintException("Já existe uma alternativa para essa questão com esse texto na base de dados.");
            }

            return modelMapper.map(alternativaRepository.save(novaAlternativa), AlternativaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar a alternativa " + novaAlternativa.getTexto() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar a alternativa " + novaAlternativa.getTexto() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar a alternativa " + novaAlternativa.getTexto() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar a alternativa " + novaAlternativa.getTexto() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public AlternativaDTO atualizar(AlternativaModel alternativaExistente) {
        try {
            if (!alternativaRepository.existsById(alternativaExistente.getId())) {
                throw new ConstraintException("Alternativa com esse ID " + alternativaExistente.getId() + " não existe na base de dados!");
            }

            return modelMapper.map(alternativaRepository.save(alternativaExistente), AlternativaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar a alternativa " + alternativaExistente.getTexto() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar a alternativa " + alternativaExistente.getTexto() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar a alternativa " + alternativaExistente.getTexto() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar a alternativa " + alternativaExistente.getTexto() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar a alternativa" + alternativaExistente.getTexto() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional
    public void deletar(AlternativaModel alternativaExistente){
        try {
            if (!alternativaRepository.existsById(alternativaExistente.getId())) {
                throw new ConstraintException("Alternativa com esse ID " + alternativaExistente.getId() + " não existe na base de dados!");
            }

            alternativaRepository.delete(alternativaExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar a alternativa " + alternativaExistente.getTexto() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar a alternativa " + alternativaExistente.getTexto() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar a alternativa " + alternativaExistente.getTexto() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar a alternativa " + alternativaExistente.getTexto() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar a alternativa" + alternativaExistente.getTexto() + ". Não encontrada no banco de dados!");
        }
    }
}
