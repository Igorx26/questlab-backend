package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.ProvaModel;
import br.com.dbug.questlab.rest.dto.ProvaDTO;
import br.com.dbug.questlab.rest.dto.RelatorioProvasConcursoDTO;
import br.com.dbug.questlab.service.ProvaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prova")
public class ProvaController {

    @Autowired
    ProvaService provaService;

    @GetMapping("/{id}")
    public ResponseEntity<ProvaDTO> obterPorId(@PathVariable int id){
        ProvaDTO provaDTO = provaService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(provaDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ProvaDTO>> obterTodos(){
        List<ProvaDTO> provaDTOList = provaService.obterTodos();
        return ResponseEntity.ok(provaDTOList);
    }


    @GetMapping("/provas-por-concurso")
    public ResponseEntity<Page<RelatorioProvasConcursoDTO>> gerarRelatorioProvasPorConcurso(
            @RequestHeader ("id-usuario") int idUsuario,
            @RequestParam ("id-concurso") Integer idConcurso,
            @RequestParam (value = "ano", required = false) Integer ano,
            @RequestParam (value = "pagina", defaultValue = "0") int pagina,
            @RequestParam (value = "tamanho", defaultValue = "10") int tamanho
    ){
        return ResponseEntity.ok(provaService.gerarRelatorioProvasPorConcurso(idUsuario, idConcurso, ano, pagina, tamanho));
    }

    @PostMapping()
    public ResponseEntity<ProvaDTO> salvar(@Valid @RequestBody ProvaModel novoProva){
        ProvaDTO novoProvaDTO = provaService.salvar(novoProva);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProvaDTO);
    }

    @PutMapping
    public ResponseEntity<ProvaDTO> atualizar(@Valid @RequestBody ProvaModel provaExistente){
        ProvaDTO provaExistenteDTO = provaService.atualizar(provaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(provaExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody ProvaModel provaExistente){
        provaService.deletar(provaExistente);
    }
}
