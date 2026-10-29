package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.ConcursoModel;
import br.com.dbug.questlab.rest.dto.ConcursoDTO;
import br.com.dbug.questlab.service.ConcursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concurso")
public class ConcursoController {

    @Autowired
    ConcursoService concursoService;

    @GetMapping("/{id}")
    public ResponseEntity<ConcursoDTO> obterPorId(@PathVariable int id){
        ConcursoDTO concursoDTO = concursoService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(concursoDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ConcursoDTO>> obterTodos(){
        List<ConcursoDTO> concursoDTOList = concursoService.obterTodos();
        return ResponseEntity.ok(concursoDTOList);
    }

    @PostMapping()
    public ResponseEntity<ConcursoDTO> salvar(@Valid @RequestBody ConcursoModel novoConcurso){
        ConcursoDTO novoConcursoDTO = concursoService.salvar(novoConcurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConcursoDTO);
    }

    @PutMapping
    public ResponseEntity<ConcursoDTO> atualizar(@Valid @RequestBody ConcursoModel concursoExistente){
        ConcursoDTO concursoExistenteDTO = concursoService.atualizar(concursoExistente);
        return ResponseEntity.status(HttpStatus.OK).body(concursoExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody ConcursoModel concursoExistente){
        concursoService.deletar(concursoExistente);
    }
}
