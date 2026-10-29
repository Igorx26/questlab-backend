package br.com.dbug.questlab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RelatorioQuestoesAnuladasDTO {
    private String enunciado;
    private String nomeDisciplina;
    private String nomeAssunto;
    private LocalDate dataAnulacao;
    private String comentarioProfessor;
}
