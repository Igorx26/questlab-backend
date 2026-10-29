package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.AssuntoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssuntoRepository extends JpaRepository<AssuntoModel, Integer> {

    // Busca todos os assuntos de uma disciplina específica
    List<AssuntoModel> findByIdDisciplina(int idDisciplina);

    // Busca assuntos pelo nome
    List<AssuntoModel> findByNomeContainingIgnoreCase(String nome);

    // Busca um assunto específico dentro de uma disciplina pelo nome
    List<AssuntoModel> findByIdDisciplinaAndNomeContainingIgnoreCase(int idDisciplina, String nome);

    boolean existsByNome(String nome);
}
