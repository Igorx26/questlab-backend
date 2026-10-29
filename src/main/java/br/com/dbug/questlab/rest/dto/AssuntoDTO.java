package br.com.dbug.questlab.rest.dto;

import lombok.Data;

@Data
public class AssuntoDTO {
    private int id;
    private String nome;
    private int idDisciplina;
}
