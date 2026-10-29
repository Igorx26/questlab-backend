package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.AlternativaModel;
import br.com.dbug.questlab.rest.dto.AlternativaDTO;
import br.com.dbug.questlab.service.AlternativaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alternativa")
public class AlternativaController {

    @Autowired
    AlternativaService alternativaService;

    @GetMapping("/{id}")
    public ResponseEntity<AlternativaDTO> obterPorId(@PathVariable int id){
        AlternativaDTO alternativaDTO = alternativaService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(alternativaDTO);
    }

    @GetMapping()
    public ResponseEntity<List<AlternativaDTO>> obterTodos(){
        List<AlternativaDTO> alternativaDTOList = alternativaService.obterTodos();
        return ResponseEntity.ok(alternativaDTOList);
    }

    @PostMapping()
    public ResponseEntity<AlternativaDTO> salvar(@Valid @RequestBody AlternativaModel novaAlternativa){
        AlternativaDTO novaAlternativaDTO = alternativaService.salvar(novaAlternativa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAlternativaDTO);
    }

    @PutMapping
    public ResponseEntity<AlternativaDTO> atualizar(@Valid @RequestBody AlternativaModel alternativaExistente){
        AlternativaDTO alternativaExistenteDTO = alternativaService.atualizar(alternativaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(alternativaExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody AlternativaModel alternativaExistente){
        alternativaService.deletar(alternativaExistente);
    }
}
