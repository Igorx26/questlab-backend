package br.com.dbug.questlab.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProvaDTO {
    private int id;
    private String nome;
    private LocalDate dataAplicacao;
    private int idConcurso;
    private int idCargo;
}
