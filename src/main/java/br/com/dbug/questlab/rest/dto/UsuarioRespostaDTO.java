package br.com.dbug.questlab.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRespostaDTO {
    private int id;
    private LocalDate dataResposta;
    private int idUsuario;
    private int idQuestao;
    private int idAlternativaEscolhida;
}
