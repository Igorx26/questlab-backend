package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.UsuarioModel;
import br.com.dbug.questlab.repository.projection.RelatorioEvolucaoProjection;
import br.com.dbug.questlab.repository.projection.RelatorioUsuariosAtivosProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    /*Nossas Implementações...*/
    Optional<UsuarioModel> findByCpf(String cpf);

    /**
     * Verifica se existe um usuário cadastrado com o cpf especificado.
     *
     * @param cpf O cpf a ser verificado.
     * @return {@code true} se existir um usuario com o cpf fornecido, {@code false} caso contrário.
     */
    boolean existsByCpf(String cpf);

    // Verifica se existe pelo celular
    boolean existsByCelular(String celular);

    /**
     * Verifica se existe um usuário cadastrado com o telefone especificado.
     *
     * @param telefone O telefone a ser verificado.
     * @return {@code true} se existir um usuário com o telefone fornecido, {@code false} caso contrário.
     */
    boolean existsByTelefone(String telefone);

    /**
     * Verifica se existe um usuário cadastrado com o e-mail especificado.
     *
     * @param email O e-mail a ser verificado.
     * @return {@code true} se existir um usuário com o e-mail fornecido, {@code false} caso contrário.
     */
    boolean existsByEmail(String email);

    List<RelatorioUsuariosAtivosProjection> findByAtivoTrue();

    long countByAtivoTrue();

    @Query(value = """
        SELECT
             D.NOME AS disciplina,
             A.NOME AS assunto,
             COUNT(UR.ID) AS totalTentativas,
             SUM(CASE WHEN AL.CORRETA = TRUE THEN  1 ELSE 0 END) AS totalAcertos
        FROM DISCIPLINA D
        INNER JOIN ASSUNTO A ON D.ID = A.ID_DISCIPLINA
        INNER JOIN QUESTAO Q ON A.ID = Q.ID_ASSUNTO
        INNER JOIN USUARIO_RESPOSTA UR ON Q.ID = UR.ID_QUESTAO
        INNER JOIN USUARIO U ON U.ID = UR.ID_USUARIO
        INNER JOIN ALTERNATIVA AL ON AL.ID = UR.ID_ALTERNATIVA_ESCOLHIDA
        WHERE U.ID = :idUsuario
        GROUP BY D.NOME, A.NOME
    """, countQuery = """
        SELECT COUNT(*) FROM (
            SELECT 1
            FROM DISCIPLINA D
            INNER JOIN ASSUNTO A ON D.ID = A.ID_DISCIPLINA
            INNER JOIN QUESTAO Q ON A.ID = Q.ID_ASSUNTO
            INNER JOIN USUARIO_RESPOSTA UR ON Q.ID = UR.ID_QUESTAO
            WHERE UR.ID_USUARIO = :idUsuario
            GROUP BY D.NOME, A.NOME
        ) AS total
    """, nativeQuery = true)
    Page<RelatorioEvolucaoProjection> buscarDadosEvolucao(
            @Param("idUsuario") int idUsuario,
            Pageable pageable
    );
}
