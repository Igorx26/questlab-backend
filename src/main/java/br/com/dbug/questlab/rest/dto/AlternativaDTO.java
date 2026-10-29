package br.com.dbug.questlab.rest.dto;

import lombok.Data;

@Data
public class AlternativaDTO {
    private int id;
    private String texto;
    private boolean correta;
    private int idQuestao;
}
