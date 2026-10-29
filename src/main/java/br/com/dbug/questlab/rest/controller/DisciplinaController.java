package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.DisciplinaModel;
import br.com.dbug.questlab.rest.dto.DisciplinaDTO;
import br.com.dbug.questlab.rest.dto.RelatorioDesempenhoDisciplinaDTO;
import br.com.dbug.questlab.rest.dto.RelatorioDesempenhoUsuarioDTO;
import br.com.dbug.questlab.service.DisciplinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> obterPorId(@PathVariable int id){
        DisciplinaDTO disciplinaDTO = disciplinaService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaDTO);
    }

    @GetMapping()
    public ResponseEntity<List<DisciplinaDTO>> obterTodos(){
        List<DisciplinaDTO> disciplinaDTOList = disciplinaService.obterTodos();
        return ResponseEntity.ok(disciplinaDTOList);
    }

    @GetMapping("/desempenho")
    public ResponseEntity<List<RelatorioDesempenhoDisciplinaDTO>> gerarRelatorioDesempenho(
            @RequestHeader("id-usuario") int idUsuario,
            @RequestParam("idDisciplina") Integer idDisciplina,
            @RequestParam(value = "id-concurso", required = false) Integer idConcurso,
            @RequestParam("data-inicial") LocalDate dataInicial,
            @RequestParam("data-final") LocalDate dataFinal
    ) {
        return ResponseEntity.ok(disciplinaService.gerarRelatorioDesempenhoDisciplina(
                idUsuario, idDisciplina, idConcurso, dataInicial, dataFinal
        ));
    }

    @PostMapping()
    public ResponseEntity<DisciplinaDTO> salvar(@Valid @RequestBody DisciplinaModel novoDisciplina){
        DisciplinaDTO novoDisciplinaDTO = disciplinaService.salvar(novoDisciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDisciplinaDTO);
    }

    @PutMapping
    public ResponseEntity<DisciplinaDTO> atualizar(@Valid @RequestBody DisciplinaModel disciplinaExistente){
        DisciplinaDTO disciplinaExistenteDTO = disciplinaService.atualizar(disciplinaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody DisciplinaModel disciplinaExistente){
        disciplinaService.deletar(disciplinaExistente);
    }
}
