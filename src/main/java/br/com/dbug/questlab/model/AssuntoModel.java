package br.com.dbug.questlab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assunto")
public class AssuntoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "O nome do assunto não pode ser nulo.")
    @NotBlank(message = "O nome do assunto é obrigatório.")
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "idDisciplina", nullable = false)
    private int idDisciplina;
}
