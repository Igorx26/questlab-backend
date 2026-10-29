package br.com.dbug.questlab.repository;

import br.com.dbug.questlab.model.InstituicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoModel, Integer> {

    // Busca pela sigla
    Optional<InstituicaoModel> findBySigla(String sigla);

    //Busca pelo CNPJ
    Optional<InstituicaoModel> findByCnpj(String cnpj);

    //Busca pela Razão Social exata
    Optional<InstituicaoModel> findByRazaoSocial(String razaoSocial);

    // Busca instituições ativas
    List<InstituicaoModel> findByAtivoTrue();

    // Verifica se exitem
    boolean existsByCnpj(String cnpj);
    boolean existsBySigla(String sigla);
    boolean existsByRazaoSocial(String razaoSocial);
    boolean existsByEmail(String email);
    boolean existsByTelefone(String telefone);
}
