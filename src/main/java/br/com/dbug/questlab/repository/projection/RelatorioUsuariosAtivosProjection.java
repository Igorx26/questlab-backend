package br.com.dbug.questlab.repository.projection;

import java.time.LocalDate;

public interface RelatorioUsuariosAtivosProjection {
    String getNome();
    String getEmail();
    String getPerfil();
    LocalDate getDataNascimento();
}
