package br.com.dbug.questlab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RelatorioUsuarioAtivoDTO {
    private String nome;
    private String email;
    private String perfil;
    private LocalDate dataNascimento;
}