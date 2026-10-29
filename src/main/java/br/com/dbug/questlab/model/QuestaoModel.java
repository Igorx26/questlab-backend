package br.com.dbug.questlab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questao")
public class QuestaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "O enunciado não pode ser nulo.")
    @NotBlank(message = "O enunciado é obrigatório.")
    @Lob
    @Column(name = "enunciado", nullable = false)
    private String enunciado;

    @Pattern(regexp = ".*\\S.*", message = "O comentário do professor, se informado, não pode estar em branco.")
    @Lob
    @Column(name = "comentarioProfessor", nullable = true)
    private String comentarioProfessor;

    @Column(name = "anulada", nullable = false)
    private boolean anulada;

    @Column(name = "idProva", nullable = false)
    private int idProva;

    @Column(name = "idAssunto", nullable = false)
    private int idAssunto;

    @Past(message = "A data de anulação deve ser anterior a data atual.")
    @Column(name = "dataAnulacao", nullable = true)
    private LocalDate dataAnulacao;

    @Past(message = "A data de criação deve ser anterior a data atual.")
    @Column(name = "dataCriacao", nullable = true)
    private LocalDate dataCriacao;
}
