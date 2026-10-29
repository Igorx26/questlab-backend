package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.BancaModel;
import br.com.dbug.questlab.rest.dto.BancaDTO;
import br.com.dbug.questlab.service.BancaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banca")
public class BancaController {

    @Autowired
    BancaService bancaService;

    @GetMapping("/{id}")
    public ResponseEntity<BancaDTO> obterPorId(@PathVariable int id){
        BancaDTO bancaDTO = bancaService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(bancaDTO);
    }

    @GetMapping()
    public ResponseEntity<List<BancaDTO>> obterTodos(){
        List<BancaDTO> bancaDTOList = bancaService.obterTodos();
        return ResponseEntity.ok(bancaDTOList);
    }

    @PostMapping()
    public ResponseEntity<BancaDTO> salvar(@Valid @RequestBody BancaModel novoBanca){
        BancaDTO novoBancaDTO = bancaService.salvar(novoBanca);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoBancaDTO);
    }

    @PutMapping
    public ResponseEntity<BancaDTO> atualizar(@Valid @RequestBody BancaModel bancaExistente){
        BancaDTO bancaExistenteDTO = bancaService.atualizar(bancaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(bancaExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody BancaModel bancaExistente){
        bancaService.deletar(bancaExistente);
    }
}
