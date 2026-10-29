package br.com.dbug.questlab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RelatorioQuestoesDisciplinaDTO {
    private String nomeDisciplina;
    private Long totalQuestoes;
    private Long totalAnuladas;
}
