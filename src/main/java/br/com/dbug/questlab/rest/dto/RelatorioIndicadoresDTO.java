package br.com.dbug.questlab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioIndicadoresDTO {
    private LocalDate dataGeracao;
    private String usuario;
    private SecaoUsuarios usuarios;
    private SecaoQuestoes bancoQuestoes;
    private SecaoDesempenho desempenhoGlobal;

    @Data
    @AllArgsConstructor
    public static class SecaoUsuarios {
        private long totalAtivos;
    }

    @Data
    @AllArgsConstructor
    public static class SecaoQuestoes {
        private long totalQuestoesCadastradas;
        private long totalQuestoesResolvidas;
    }

    @Data
    @AllArgsConstructor
    public static class SecaoDesempenho {
        private double percentualAcerto;
        private double crescimentoBanco;
    }
}