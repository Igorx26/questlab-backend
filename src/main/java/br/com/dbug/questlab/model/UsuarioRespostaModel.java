package br.com.dbug.questlab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarioResposta")
public class UsuarioRespostaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dataResposta", nullable = false)
    private LocalDate dataResposta;

    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;

    @Column(name = "idQuestao", nullable = false)
    private int idQuestao;

    @Column(name = "idAlternativaEscolhida", nullable = false)
    private int idAlternativaEscolhida;
}
