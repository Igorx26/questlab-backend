package br.com.dbug.questlab.repository.projection;

import java.time.LocalDate;

public interface RelatorioProvasConcursoProjection {
    String getNomeConcurso();
    Integer getAnoConcurso();
    String getNomeProva();
    String getNomeCargo();
    LocalDate getDataAplicacao();
}
