package br.com.dbug.questlab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RelatorioProvasConcursoDTO {
    private String nomeConcurso;
    private Integer anoConcurso;
    private String nomeProva;
    private String nomeCargo;
    private LocalDate dataAplicacao;
}