package br.com.dbug.questlab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "O nome do usuário não pode ser nulo.")
    @NotBlank(message = "O nome do usuário é obrigatório.")
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @NotNull(message = "O e-mail não pode ser nulo.")
    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail é inválido.")
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Past(message = "A data de nascimento deve ser anterior a data atual.")
    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotNull(message = "O sexo não pode ser nulo.")
    @NotBlank(message = "O sexo é obrigatório.")
    @Column(name = "sexo", length = 1, nullable = false)
    private String sexo;

    @NotNull(message = "A senha não pode ser nula.")
    @NotBlank(message = "A senha é obrigatória.")
    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @NotNull(message = "O perfil não pode ser nulo.")
    @NotBlank(message = "O perfil é obrigatório.")
    @Column(name = "perfil", length = 32, nullable = false)
    private String perfil;

    @NotNull(message = "O cpf não pode ser nulo.")
    @NotBlank(message = "O cpf é obrigatório.")
    @CPF(message = "O CPF é inválido.")
    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @NotNull(message = "O celular não pode ser nulo.")
    @NotBlank(message = "O celular é obrigatório.")
    @Column(name = "celular", length = 11, nullable = false, unique = true)
    private String celular;

    @Pattern(regexp = "\\d{10}", message = "O telefone, se informado, deve conter 10 dígitos.")
    @Column(name = "telefone", length = 10, nullable = true)
    private String telefone;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;
}
