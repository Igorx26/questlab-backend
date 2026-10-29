package br.com.dbug.questlab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instituicao")
public class InstituicaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "A razão social não pode ser nula.")
    @NotBlank(message = "A razão social é obrigatória.")
    @Column(name = "razaoSocial", length = 255, nullable = false, unique = true)
    private String razaoSocial;

    @NotNull(message = "A sigla não pode ser nula.")
    @NotBlank(message = "A sigla é obrigatória.")
    @Column(name = "sigla", length = 255, nullable = false, unique = true)
    private String sigla;

    @NotNull(message = "O CNPJ não pode ser nulo.")
    @NotBlank(message = "O CNPJ é obrigatório.")
    @CNPJ(message = "O CNPJ é inválido.")
    @Column(name = "cnpj", length = 14, nullable = false, unique = true)
    private String cnpj;

    @NotNull(message = "O e-mail não pode ser nulo.")
    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O E-mail é inválido.")
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @NotNull(message = "O telefone não pode ser nulo.")
    @NotBlank(message = "O telefone é obrigatório.")
    @Column(name = "telefone", length = 11, nullable = false, unique = true)
    private String telefone;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;
}