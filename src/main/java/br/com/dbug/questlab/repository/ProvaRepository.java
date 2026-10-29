package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.ProvaModel;
import br.com.dbug.questlab.repository.projection.RelatorioProvasConcursoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProvaRepository extends JpaRepository<ProvaModel, Integer> {

    // Busca pelo nome exato
    Optional<ProvaModel> findByNome(String nome);

    // Busca provas aplicadas por um intervalo
    List<ProvaModel> findByDataAplicacaoBetween(LocalDate dataInicio, LocalDate dataFim);

    //Busca provas de um concurso específico
    List<ProvaModel> findByIdConcurso(int idConcurso);

    //Busca provas de um cargo específico
    List<ProvaModel> findByIdCargo(int idCargo);

    //Montando um SQL Nativo conforme a regra de negócio especificada... O CÉU É O LIMITE!
    @Query(value = """
            select	prova.*
            	from [dbo].[banca]
            	inner join [dbo].[concurso]
            		on (banca.id = concurso.idBanca)
            	inner join [dbo].[instituicao]
            		on (instituicao.id = concurso.idInstituicao)
            	inner join [dbo].[prova]
            		on (prova.idConcurso = concurso.id)
            	where banca.sigla = :pSiglaBanca
            """, nativeQuery = true)
    List<ProvaModel> obterProvasPorBanca(@Param("pSiglaBanca") String pSiglaBanca);

    boolean existsByNomeAndDataAplicacaoAndIdConcurso(String nome, LocalDate dataAplicacao, int idConcurso);

    @Query(value = """
        SELECT
            C.nome AS nomeConcurso,
            EXTRACT(YEAR FROM C.ano) AS anoConcurso,
            P.nome AS nomeProva,
            CA.nome AS nomeCargo,
            P.data_aplicacao AS dataAplicacao
        FROM prova AS P
        INNER JOIN concurso AS C ON P.id_concurso = C.id
        INNER JOIN cargo AS CA ON P.id_cargo = CA.id
        WHERE
            C.ATIVO = TRUE
            AND C.cancelado = FALSE
            AND (:idConcurso IS NULL OR C.id = :idConcurso)
            AND (:ano IS NULL OR EXTRACT(YEAR FROM C.ano) = :ano)
        """, countQuery = """
        SELECT count(*)
        FROM prova AS P
        INNER JOIN concurso AS C ON P.id_concurso = C.id
        INNER JOIN cargo AS CA ON P.id_cargo = CA.id
        WHERE
            C.ATIVO = TRUE
            AND C.cancelado = FALSE
            AND (:idConcurso IS NULL OR C.id = :idConcurso)
            AND (:ano IS NULL OR EXTRACT(YEAR FROM C.ano) = :ano)
    """, nativeQuery = true)
    Page<RelatorioProvasConcursoProjection> buscarRelatorioProvas(
            @Param("idConcurso") Integer idConcurso,
            @Param("ano") Integer ano,
            Pageable pageable
    );
}
