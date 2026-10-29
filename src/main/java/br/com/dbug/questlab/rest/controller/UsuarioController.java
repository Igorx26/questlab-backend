package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.UsuarioModel;
import br.com.dbug.questlab.rest.dto.*;
import br.com.dbug.questlab.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos usuários.
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    /**
     * Instância do serviço de usuários, responsável por encapsular a lógica de negócios
     * e intermediar as operações entre o controlador e o repositório.
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtém um usuaário pelo ID.
     * Link: http://localhost:8080/questlab/usuario/?
     *
     * @param id ID do usuário.
     * @return usuarioDTO representando o usuário encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obterPorId(@PathVariable int id) {
        UsuarioDTO usuarioDTO = usuarioService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
    }

    /**
     * Obtém a lista de todos os usuários cadastrados.
     * Link: http://localhost:8080/questlab/usuario
     *
     * @return Lista de usuarioDTO representando os usuarios cadastrados.
     */
    @GetMapping()
    public ResponseEntity<List<UsuarioDTO>> obterTodos() {
        List<UsuarioDTO> usuarioDTOList = usuarioService.obterTodos();
        return ResponseEntity.ok(usuarioDTOList);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<RelatorioUsuarioAtivoDTO>> listarUsuariosAtivos(
            @RequestHeader("id-usuario") int idUsuario
    ) {
        return ResponseEntity.ok(usuarioService.gerarRelatorioUsuariosAtivos(idUsuario));
    }

    @GetMapping("/desempenho/{idUsuarioAlvo}")
    public ResponseEntity<RelatorioDesempenhoUsuarioDTO> gerarRelatorioDesempenho(
            @RequestHeader("id-usuario-solicitante") int idUsuarioSolicitante,
            @PathVariable("idUsuarioAlvo") int idUsuarioAlvo,
            @RequestParam(required = false)LocalDate dataInicial,
            @RequestParam(required = false)LocalDate dataFinal
            ) {
        return ResponseEntity.ok(usuarioService.gerarRelatorioDesempenhoUsuario(
                idUsuarioSolicitante, idUsuarioAlvo, dataInicial, dataFinal
        ));
    }

    @GetMapping("/participacao")
    public ResponseEntity<RelatorioParticipacaoDTO> gerarRelatorioGeral(
            @RequestHeader("id-usuario") int idUsuario,
            @RequestParam("mes") int mes,
            @RequestParam("ano") int ano
    ) {
        return ResponseEntity.ok(
                usuarioService.gerarRelatorioParticipacao(idUsuario, mes, ano)
        );
    }

    @GetMapping("/evolucao")
    public ResponseEntity<Page<RelatorioEvolucaoDTO>> getRelatorioEvolucao(
            @RequestHeader("id-usuario") int idUsuarioSolicitante,
            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") int tamanho
    ) {
        return ResponseEntity.ok(
                usuarioService.gerarRelatorioEvolucao(idUsuarioSolicitante, pagina, tamanho)
        );
    }

    @GetMapping("/indicadores")
    public ResponseEntity<RelatorioIndicadoresDTO> getRelatorioIndicadores(
            @RequestHeader("id-usuario") int idUsuario
    ) {
        return ResponseEntity.ok(
                usuarioService.gerarRelatorioIndicadores(idUsuario)
        );
    }

    /**
     * Salva um novo usuario na base de dados.
     * Link: http://localhost:8080/questlab/usuario
     *
     * @param novoUsuario UsuarioModel contendo os dados do novo usuario.
     * @return usuarioDTO representando o usuario salvo.
     */
    @PostMapping()
    public ResponseEntity<UsuarioDTO> salvar(@Valid @RequestBody UsuarioModel novoUsuario) {
        UsuarioDTO novoUsuarioDTO = usuarioService.salvar(novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuarioDTO);
    }

    /**
     * Atualiza os dados de um usuario existente.
     * Link: http://localhost:8080/questlab/usuario
     *
     * @param usuarioExistenteDTO usuarioModel contendo os dados atualizados do usuario.
     * @return usuarioDTO representando o usuario atualizado.
     */
    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizar(@Valid @RequestBody UsuarioModel usuarioExistenteDTO) {
        UsuarioDTO usuarioExistente = usuarioService.atualizar(usuarioExistenteDTO);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioExistente);
    }

    /**
     * Deleta um usuario da base de dados.
     * Link: http://localhost:8080/questlab/usuario
     *
     * @param usuarioExistente usuarioModel contendo os dados do usuario a ser deletado.
     */
    @DeleteMapping
    public void deletar(@Valid @RequestBody UsuarioModel usuarioExistente) {

        usuarioService.deletar(usuarioExistente);
    }
}