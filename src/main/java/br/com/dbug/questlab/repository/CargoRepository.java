package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<CargoModel, Integer> {

    // Busca pelo nome exato
    Optional<CargoModel> findByNome(String nome);

    // Busca todos os cargos de um mesmo nível de escolaridade
    List<CargoModel> findByNivelEscolaridadeIgnoreCase(String nivel);

    // Busca cargos por parte do nome
    List<CargoModel> findByNomeContainingIgnoreCase(String nome);

    boolean existsByNome(String nome);
}
