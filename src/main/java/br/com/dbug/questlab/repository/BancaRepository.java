package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.BancaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BancaRepository extends JpaRepository<BancaModel, Integer> {

    // Busca pela sigla
    Optional<BancaModel> findBySigla(String sigla);

    //Busca pelo CNPJ
    Optional<BancaModel> findByCnpj(String cnpj);

    //Busca pela Razão Social exata
    Optional<BancaModel> findByRazaoSocial(String razaoSocial);

    // Busca bancas ativas
    List<BancaModel> findByAtivoTrue();

    // Verifica se existem
    boolean existsByCnpj(String cnpj);
    boolean existsBySigla(String sigla);
    boolean existsByRazaoSocial(String razaoSocial);
    boolean existsByEmail(String email);
    boolean existsByTelefone(String telefone);
}
