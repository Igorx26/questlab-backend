package br.com.dbug.questlab.rest.dto;

import lombok.Data;

@Data
public class InstituicaoDTO {
    private int id;
    private String razaoSocial;
    private String sigla;
    private String cnpj;
    private String email;
    private String telefone;
    private boolean ativo;
}
