package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.CargoModel;
import br.com.dbug.questlab.repository.CargoRepository;
import br.com.dbug.questlab.rest.dto.CargoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public CargoDTO obterPorId(int id){
        CargoModel cargoModel = cargoRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Cargo com ID "+ id +" não encontrado."));
        return modelMapper.map(cargoModel, CargoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<CargoDTO> obterTodos() {
        List<CargoModel> cargos = cargoRepository.findAll();
        return cargos.stream()
                .map(cargo -> modelMapper.map(cargo, CargoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public CargoDTO salvar(CargoModel novoCargo) {
        try {

            if (cargoRepository.existsByNome(novoCargo.getNome())){
                throw new ConstraintException("Já existe um cargo com o nome "+ novoCargo.getNome() +" na base de dados.");
            }

            return modelMapper.map(cargoRepository.save(novoCargo), CargoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o cargo " + novoCargo.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o cargo " + novoCargo.getNome() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar o cargo " + novoCargo.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar o cargo " + novoCargo.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public CargoDTO atualizar(CargoModel cargoExistente) {
        try {
            if (!cargoRepository.existsById(cargoExistente.getId())) {
                throw new ConstraintException("Cargo com esse ID " + cargoExistente.getId() + " não existe na base de dados!");
            }

            return modelMapper.map(cargoRepository.save(cargoExistente), CargoDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o cargo " + cargoExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar o cargo " + cargoExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o cargo " + cargoExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o cargo " + cargoExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o cargo" + cargoExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }

    @Transactional
    public void deletar(CargoModel cargoExistente){
        try {
            if (!cargoRepository.existsById(cargoExistente.getId())) {
                throw new ConstraintException("Cargo com esse ID " + cargoExistente.getId() + " não existe na base de dados!");
            }

            cargoRepository.delete(cargoExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o cargo " + cargoExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar o cargo " + cargoExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar o cargo " + cargoExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar o cargo " + cargoExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o cargo" + cargoExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
}
