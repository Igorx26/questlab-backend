package br.com.dbug.questlab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RelatorioParticipacaoDTO {
    private long totalUsuarios;
    private long totalUsuariosAtivos;
    private long totalQuestoesRespondidasNoPeriodo;
    private double crescimentoPercentual;
}
