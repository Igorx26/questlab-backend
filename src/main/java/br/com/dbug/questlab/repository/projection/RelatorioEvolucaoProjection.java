package br.com.dbug.questlab.repository.projection;

public interface RelatorioEvolucaoProjection {
    String getDisciplina();
    String getAssunto();
    long getTotalTentativas();
    long getTotalAcertos();
}
