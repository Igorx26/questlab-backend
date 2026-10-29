package br.com.dbug.questlab.rest.dto;

import lombok.Data;

@Data
public class RelatorioEvolucaoDTO {
    private String disciplina;
    private String assunto;
    private long totalTentativas;
    private double percentualAcertos;
}
