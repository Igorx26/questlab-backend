package br.com.dbug.questlab.repository.projection;

public interface RelatorioDesempenhoDisciplinaProjection {
    String getDisciplina();
    long getTotalTentativas();
    long getTotalAcertos();
}
