package br.com.dbug.questlab.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QuestaoDTO {
    private int id;
    private String enunciado;
    private String comentarioProfessor;
    private boolean anulada;
    private int idProva;
    private int idAssunto;
    private LocalDate dataAnulacao;
    private LocalDate dataCriacao;
}
