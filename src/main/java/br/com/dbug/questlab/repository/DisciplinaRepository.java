package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.DisciplinaModel;
import br.com.dbug.questlab.repository.projection.RelatorioDesempenhoDisciplinaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Integer> {

    // Busca pelo nome exato
    Optional<DisciplinaModel> findByNome(String nome);

    // Busca por parte do nome ignorando maiúsculas e minúsculas
    List<DisciplinaModel> findByNomeContainingIgnoreCase(String nome);

    // Verifica se já existe uma disciplina com o nome
    boolean existsByNome(String nome);

    @Query(value = """
            SELECT
                 D.NOME AS disciplina,
                 COUNT(UR.ID) AS totalTentativas,
                 SUM(CASE WHEN AL.CORRETA = TRUE THEN  1 ELSE 0 END) AS totalAcertos
            FROM DISCIPLINA D
            INNER JOIN ASSUNTO A ON D.ID = A.ID_DISCIPLINA
            INNER JOIN QUESTAO Q ON A.ID = Q.ID_ASSUNTO
            INNER JOIN USUARIO_RESPOSTA UR ON Q.ID = UR.ID_QUESTAO
            INNER JOIN ALTERNATIVA AL ON AL.ID = UR.ID_ALTERNATIVA_ESCOLHIDA
            INNER JOIN PROVA P ON Q.ID_PROVA = P.ID
            INNER JOIN CONCURSO C ON P.ID_CONCURSO = C.ID
            WHERE
                Q.ANULADA = FALSE
                AND D.ID = :idDisciplina
                AND (:idConcurso IS NULL OR C.ID = :idConcurso)
                AND UR.DATA_RESPOSTA BETWEEN :dataInicial and :dataFinal
            GROUP BY D.NOME
            """, nativeQuery = true)
    List<RelatorioDesempenhoDisciplinaProjection> buscarDadosDisciplina(
            @Param("idDisciplina") Integer idDisciplina,
            @Param("idConcurso") Integer idConcurso,
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal
    );

    @Query(value = """
        SELECT COUNT(Q.ID)
        FROM QUESTAO Q
        INNER JOIN ASSUNTO A ON Q.ID_ASSUNTO = A.ID
        INNER JOIN PROVA P ON Q.ID_PROVA = P.ID
        WHERE
            Q.ANULADA = TRUE
            AND A.ID_DISCIPLINA = :idDisciplina
            AND (:idConcurso IS NULL OR P.ID_CONCURSO = :idConcurso)
    """, nativeQuery = true)
    long contarAnuladas(
            @Param("idDisciplina") Integer idDisciplina,
            @Param("idConcurso") Integer idConcurso
    );

}
