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
@Table(name = "alternativa")
public class AlternativaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "O texto da alternativa não pode ser nulo.")
    @NotBlank(message = "O texto da alternativa é obrigatório.")
    @Lob
    @Column(name = "texto", nullable = false)
    private String texto;

    @Column(name = "correta", nullable = false)
    private boolean correta;

    @Column(name = "idQuestao", nullable = false)
    private int idQuestao;
}