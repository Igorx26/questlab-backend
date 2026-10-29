package br.com.dbug.questlab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RelatorioDesempenhoDisciplinaDTO {
    private String disciplina;
    private double mediaAcertos;
    private long totalTentativas;
    private long qtdQuestoesAnuladas;
}
