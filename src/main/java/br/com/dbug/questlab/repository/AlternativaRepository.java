package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.AlternativaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlternativaRepository extends JpaRepository<AlternativaModel, Integer> {

    // Busca todas as alternativas de uma questão
    List<AlternativaModel> findByIdQuestao(int idQuestao);

    // Busca apenas a alternativa correta de uma questão
    Optional<AlternativaModel> findByIdQuestaoAndCorretaTrue(int idQuestao);

    // Busca as alternativas erradas de uma questão
    List<AlternativaModel> findByIdQuestaoAndCorretaFalse(int idQuestao);

    boolean existsByTexto(String texto);
}
