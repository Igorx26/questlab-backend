package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.InstituicaoModel;
import br.com.dbug.questlab.rest.dto.InstituicaoDTO;
import br.com.dbug.questlab.service.InstituicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    InstituicaoService instituicaoService;

    @GetMapping("/{id}")
    public ResponseEntity<InstituicaoDTO> obterPorId(@PathVariable int id){
        InstituicaoDTO instituicaoDTO = instituicaoService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(instituicaoDTO);
    }

    @GetMapping()
    public ResponseEntity<List<InstituicaoDTO>> obterTodos(){
        List<InstituicaoDTO> instituicaoDTOList = instituicaoService.obterTodos();
        return ResponseEntity.ok(instituicaoDTOList);
    }

    @PostMapping()
    public ResponseEntity<InstituicaoDTO> salvar(@Valid @RequestBody InstituicaoModel novoInstituicao){
        InstituicaoDTO novoInstituicaoDTO = instituicaoService.salvar(novoInstituicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoInstituicaoDTO);
    }

    @PutMapping
    public ResponseEntity<InstituicaoDTO> atualizar(@Valid @RequestBody InstituicaoModel instituicaoExistente){
        InstituicaoDTO instituicaoExistenteDTO = instituicaoService.atualizar(instituicaoExistente);
        return ResponseEntity.status(HttpStatus.OK).body(instituicaoExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody InstituicaoModel instituicaoExistente){
        instituicaoService.deletar(instituicaoExistente);
    }
}
