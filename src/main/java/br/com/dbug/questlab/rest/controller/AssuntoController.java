package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.AssuntoModel;
import br.com.dbug.questlab.rest.dto.AssuntoDTO;
import br.com.dbug.questlab.service.AssuntoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assunto")
public class AssuntoController {

    @Autowired
    AssuntoService assuntoService;

    @GetMapping("/{id}")
    public ResponseEntity<AssuntoDTO> obterPorId(@PathVariable int id){
        AssuntoDTO assuntoDTO = assuntoService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(assuntoDTO);
    }

    @GetMapping()
    public ResponseEntity<List<AssuntoDTO>> obterTodos(){
        List<AssuntoDTO> assuntoDTOList = assuntoService.obterTodos();
        return ResponseEntity.ok(assuntoDTOList);
    }

    @PostMapping()
    public ResponseEntity<AssuntoDTO> salvar(@Valid @RequestBody AssuntoModel novoAssunto){
        AssuntoDTO novoAssuntoDTO = assuntoService.salvar(novoAssunto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAssuntoDTO);
    }

    @PutMapping
    public ResponseEntity<AssuntoDTO> atualizar(@Valid @RequestBody AssuntoModel assuntoExistente){
        AssuntoDTO assuntoExistenteDTO = assuntoService.atualizar(assuntoExistente);
        return ResponseEntity.status(HttpStatus.OK).body(assuntoExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody AssuntoModel assuntoExistente){
        assuntoService.deletar(assuntoExistente);
    }
}
