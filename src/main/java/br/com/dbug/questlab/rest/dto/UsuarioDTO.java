package br.com.dbug.questlab.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioDTO {
    private int id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String sexo;
    private String perfil;
    private String cpf;
    private String celular;
    private String telefone;
    private boolean ativo;
}
