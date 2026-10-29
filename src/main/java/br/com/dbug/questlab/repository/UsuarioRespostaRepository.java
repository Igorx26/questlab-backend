package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.UsuarioRespostaModel;
import br.com.dbug.questlab.repository.projection.RelatorioDesempenhoUsuarioProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRespostaRepository extends JpaRepository<UsuarioRespostaModel, Integer> {

    // Busca todas as respostas de um usuário
    List<UsuarioRespostaModel> findByIdUsuario(int idUsuario);

    // Busca todas as respostas de um usuário para uma questão específica
    List<UsuarioRespostaModel> findByIdUsuarioAndIdQuestao(int idUsuario, int idQuestao);

    // Busca a última resposta de um usuário para uma questão
    Optional<UsuarioRespostaModel> findTopByIdUsuarioAndIdQuestaoOrderByIdDesc(int idUsuario, int idQuestao);

    boolean existsByIdUsuarioAndIdQuestao(int idUsuario, int idQuestao);

    @Query(value = """
        SELECT
            A.CORRETA  AS CORRETA
        FROM USUARIO_RESPOSTA AS UR
        JOIN ALTERNATIVA A ON UR.ID_ALTERNATIVA_ESCOLHIDA  = A.ID
        WHERE
            UR.ID_USUARIO = :idUsuario
            AND (:dataInicial IS NULL OR UR.DATA_RESPOSTA >= :dataInicial)
            AND (:dataFinal IS NULL OR UR.DATA_RESPOSTA <= :dataFinal)
    """, nativeQuery = true)
    List<RelatorioDesempenhoUsuarioProjection> buscarRespostasDoUsuario(
            @Param("idUsuario") int idUsuario,
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal
    );

    @Query("SELECT COUNT(UR) FROM UsuarioRespostaModel AS UR WHERE UR.dataResposta BETWEEN :dataInicial AND :dataFinal")
    long countRespostasPorPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal
    );

    @Query(value = """
        SELECT COUNT(*)
        FROM USUARIO_RESPOSTA UR
        INNER JOIN ALTERNATIVA A ON UR.ID_ALTERNATIVA_ESCOLHIDA = A.ID
        WHERE A.CORRETA = TRUE
    """, nativeQuery = true)
    long countTotalAcertos();
}
