package br.com.dbug.questlab.repository.projection;

import java.time.LocalDate;

public interface RelatorioQuestoesAnuladasProjection {
    String getEnunciado();
    String getNomeDisciplina();
    String getNomeAssunto();
    LocalDate getDataAnulacao();
    String getComentarioProfessor();
}
