package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.QuestaoModel;
import br.com.dbug.questlab.repository.projection.RelatorioQuestoesAnuladasProjection;
import br.com.dbug.questlab.repository.projection.RelatorioQuestoesDisciplinaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface QuestaoRepository extends JpaRepository<QuestaoModel, Integer> {

    // Busca todas as questões de uma prova
    List<QuestaoModel> findByIdProva(int idProva);

    // Busca todas as questões de um assunto
    List<QuestaoModel> findByIdAssunto(int idAssunto);

    // Busca questões anuladas
    List<QuestaoModel> findByAnuladaTrue();

    // Busca questões não anuladas de uma prova
    List<QuestaoModel> findByIdProvaAndAnuladaFalse(int idProva);

    boolean existsByEnunciado(String enunciado);

    long countByDataCriacaoBefore(LocalDate data);

    @Query(value = """
        SELECT
            D.nome AS nomeDisciplina,
            COUNT(Q.id) AS totalQuestoes,
            SUM(CASE WHEN Q.anulada = true THEN 1 ELSE 0 END) AS totalAnuladas
        FROM QUESTAO AS Q
        INNER JOIN ASSUNTO AS A ON Q.id_assunto = A.id
        INNER JOIN DISCIPLINA AS D ON D.id = A.id_disciplina
        GROUP BY D.nome
        ORDER BY totalQuestoes DESC
    """, nativeQuery = true)
    List<RelatorioQuestoesDisciplinaProjection> buscarQuestoesPorDisciplina();

    @Query(value = """
        SELECT
            CAST(Q.enunciado AS VARCHAR) AS enunciado,
            D.nome AS nomeDisciplina,
            A.nome AS nomeAssunto,
            Q.data_anulacao AS dataAnulacao,
            CAST(Q.comentario_professor AS VARCHAR) AS comentarioProfessor
        FROM QUESTAO AS Q
        INNER JOIN ASSUNTO AS A ON Q.id_assunto = A.id
        INNER JOIN DISCIPLINA AS D ON D.id = A.id_disciplina
        WHERE
            Q.anulada = TRUE
            AND data_anulacao BETWEEN :dataInicial and :dataFinal
    """, countQuery = """
        SELECT count(*)
        FROM QUESTAO AS Q
        INNER JOIN ASSUNTO AS A ON Q.id_assunto = A.id
        INNER JOIN DISCIPLINA AS D ON D.id = A.id_disciplina
        WHERE
            Q.anulada = TRUE
            AND data_anulacao BETWEEN :dataInicial and :dataFinal
    """, nativeQuery = true)
    Page<RelatorioQuestoesAnuladasProjection> buscarQuestoesAnuladasPorPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal,
            Pageable pageable
    );
}
