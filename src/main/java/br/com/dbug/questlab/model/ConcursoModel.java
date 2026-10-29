package br.com.dbug.questlab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "concurso")
public class ConcursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "O nome do concurso não pode ser nulo.")
    @NotBlank(message = "O nome do concurso é obrigatório.")
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "ano", nullable = false)
    private LocalDate ano;

    @Column(name = "cancelado", nullable = false)
    private boolean cancelado;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "idBanca", nullable = false)
    private int idBanca;

    @Column(name = "idInstituicao", nullable = false)
    private int idInstituicao;
}