package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.UsuarioRespostaModel;
import br.com.dbug.questlab.rest.dto.UsuarioRespostaDTO;
import br.com.dbug.questlab.service.UsuarioRespostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario-resposta")
public class UsuarioRespostaController {

    @Autowired
    UsuarioRespostaService usuarioRespostaService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRespostaDTO> obterPorId(@PathVariable int id){
        UsuarioRespostaDTO usuarioRespostaDTO = usuarioRespostaService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRespostaDTO);
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioRespostaDTO>> obterTodos(){
        List<UsuarioRespostaDTO> usuarioRespostaDTOList = usuarioRespostaService.obterTodos();
        return ResponseEntity.ok(usuarioRespostaDTOList);
    }

    @PostMapping()
    public ResponseEntity<UsuarioRespostaDTO> salvar(@Valid @RequestBody UsuarioRespostaModel novoUsuarioResposta){
        UsuarioRespostaDTO novoUsuarioRespostaDTO = usuarioRespostaService.salvar(novoUsuarioResposta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuarioRespostaDTO);
    }

    @PutMapping
    public ResponseEntity<UsuarioRespostaDTO> atualizar(@Valid @RequestBody UsuarioRespostaModel usuarioRespostaExistente){
        UsuarioRespostaDTO usuarioRespostaExistenteDTO = usuarioRespostaService.atualizar(usuarioRespostaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRespostaExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody UsuarioRespostaModel usuarioRespostaExistente){
        usuarioRespostaService.deletar(usuarioRespostaExistente);
    }
}
