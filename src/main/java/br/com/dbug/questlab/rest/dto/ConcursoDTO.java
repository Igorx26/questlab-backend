package br.com.dbug.questlab.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConcursoDTO {
    private int id;
    private String nome;
    private LocalDate ano;
    private boolean cancelado;
    private boolean ativo;
    private int idBanca;
    private int idInstituicao;
}
