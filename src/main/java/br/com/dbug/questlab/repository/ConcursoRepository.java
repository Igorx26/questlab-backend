package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.ConcursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConcursoRepository extends JpaRepository<ConcursoModel, Integer> {

    // Busca todos os concursos de uma banca específica
    List<ConcursoModel> findByIdBanca(int idBanca);

    // Busca todos os concursos de uma instituição específica
    List<ConcursoModel> findByIdInstituicao(int idInstituicao);

    // Busca concursos pelo ano
    List<ConcursoModel> findByAno(LocalDate ano);

    // Busca concursos por um intervalo de anos
    List<ConcursoModel> findByAnoBetween(LocalDate anoInicio, LocalDate anoFim);

    // Busca concursos ativos
    List<ConcursoModel> findByAtivoTrue();

    // Busca concursos cancelados
    List<ConcursoModel> findByCanceladoTrue();

    // Busca concursos ativos de uma banca específica
    List<ConcursoModel> findByIdBancaAndAtivoTrue(int idBanca);

    boolean existsByNomeAndAno(String nome, LocalDate ano);
}
