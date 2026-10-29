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
@Table(name = "prova")
public class ProvaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "O nome não pode ser nulo.")
    @NotBlank(message = "O nome é obrigatório.")
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "dataAplicacao", nullable = true)
    private LocalDate dataAplicacao;

    @Column(name = "idConcurso", nullable = false)
    private int idConcurso;

    @Column(name = "idCargo", nullable = false)
    private int idCargo;
}
