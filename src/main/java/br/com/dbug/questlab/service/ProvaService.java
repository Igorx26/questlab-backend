package br.com.dbug.questlab.service;

import br.com.dbug.questlab.exception.*;
import br.com.dbug.questlab.model.ProvaModel;
import br.com.dbug.questlab.repository.ProvaRepository;
import br.com.dbug.questlab.repository.projection.RelatorioProvasConcursoProjection;
import br.com.dbug.questlab.rest.dto.ProvaDTO;
import br.com.dbug.questlab.rest.dto.RelatorioProvasConcursoDTO;
import br.com.dbug.questlab.rest.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository provaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional(readOnly = true)
    public ProvaDTO obterPorId(int id){
        ProvaModel provaModel = provaRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Prova com ID "+ id +" não encontrada."));
        return modelMapper.map(provaModel, ProvaDTO.class);
    }

    @Transactional(readOnly = true)
    public List<ProvaDTO> obterTodos() {
        List<ProvaModel> provas = provaRepository.findAll();
        return provas.stream()
                .map(prova -> modelMapper.map(prova, ProvaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProvaDTO salvar(ProvaModel novaProva) {
        try {

            if (provaRepository.existsByNomeAndDataAplicacaoAndIdConcurso(novaProva.getNome(), novaProva.getDataAplicacao(), novaProva.getIdConcurso())){
                throw new ConstraintException("Já existe uma prova com o nome "+ novaProva.getNome() +" para esse ano e concurso na base de dados.");
            }

            return modelMapper.map(provaRepository.save(novaProva), ProvaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar a prova " + novaProva.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar a prova " + novaProva.getNome() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar a prova " + novaProva.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar a prova " + novaProva.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public ProvaDTO atualizar(ProvaModel provaExistente) {
        try {
            if (!provaRepository.existsById(provaExistente.getId())) {
                throw new ConstraintException("Prova com esse ID " + provaExistente.getId() + " não existe na base de dados!");
            }

            return modelMapper.map(provaRepository.save(provaExistente), ProvaDTO.class);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar a prova " + provaExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar a prova " + provaExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar a prova " + provaExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar a prova " + provaExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar a prova" + provaExistente.getNome() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional
    public void deletar(ProvaModel provaExistente){
        try {
            if (!provaRepository.existsById(provaExistente.getId())) {
                throw new ConstraintException("Prova com esse ID " + provaExistente.getId() + " não existe na base de dados!");
            }

            provaRepository.delete(provaExistente);

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar a prova " + provaExistente.getNome() + " !");
        } catch (ConstraintException e) {
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar a prova " + provaExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar a prova " + provaExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar a prova " + provaExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar a prova" + provaExistente.getNome() + ". Não encontrada no banco de dados!");
        }
    }

    @Transactional(readOnly = true)
    public Page<RelatorioProvasConcursoDTO> gerarRelatorioProvasPorConcurso(int idUsuario, Integer idConcurso, Integer ano, int pagina, int tamanho) {
        UsuarioDTO usuarioDTO = usuarioService.obterPorId(idUsuario);
        if (!"ADMIN".equalsIgnoreCase(usuarioDTO.getPerfil())){
            throw new BusinessRuleException("O usuário não tem acesso a esse relatório.");
        }

        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.Direction.DESC, "dataAplicacao");
        Page<RelatorioProvasConcursoProjection> resultado = provaRepository.buscarRelatorioProvas(idConcurso, ano, pageable);

        return resultado.map(r -> new RelatorioProvasConcursoDTO(
                r.getNomeConcurso(),
                r.getAnoConcurso(),
                r.getNomeProva(),
                r.getNomeCargo(),
                r.getDataAplicacao()
        ));
    }
}
