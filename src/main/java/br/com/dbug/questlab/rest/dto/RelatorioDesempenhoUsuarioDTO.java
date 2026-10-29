package br.com.dbug.questlab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RelatorioDesempenhoUsuarioDTO {
    private long totalRespondidas;
    private long totalAcertos;
    private long totalErros;
    private double taxaAproveitamento;
}