package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.QuestaoModel;
import br.com.dbug.questlab.rest.dto.QuestaoDTO;
import br.com.dbug.questlab.rest.dto.RelatorioQuestoesAnuladasDTO;
import br.com.dbug.questlab.rest.dto.RelatorioQuestoesDisciplinaDTO;
import br.com.dbug.questlab.service.QuestaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/questao")
public class QuestaoController {

    @Autowired
    QuestaoService questaoService;

    @GetMapping("/{id}")
    public ResponseEntity<QuestaoDTO> obterPorId(@PathVariable int id){
        QuestaoDTO questaoDTO = questaoService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(questaoDTO);
    }

    @GetMapping()
    public ResponseEntity<List<QuestaoDTO>> obterTodos(){
        List<QuestaoDTO> questaoDTOList = questaoService.obterTodos();
        return ResponseEntity.ok(questaoDTOList);
    }

    @GetMapping("/questoes-por-disciplina")
    public ResponseEntity<List<RelatorioQuestoesDisciplinaDTO>> gerarRelatorioQuestoesPorDisciplina(
            @RequestHeader("id-usuario") int idUsuario
    ){
        return ResponseEntity.ok(questaoService.gerarRelatorioQuestoesPorDisciplina(idUsuario));
    }

    @GetMapping("/questoes-anuladas")
    public ResponseEntity<Page<RelatorioQuestoesAnuladasDTO>> gerarRelatorioQuestoesAnuladasPorPeriodo(
            @RequestHeader("id-usuario") int idUsuario,
            @RequestParam("data-inicial") LocalDate dataInicial,
            @RequestParam("data-final") LocalDate dataFinal,
            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") int tamanho
    ){
        return ResponseEntity.ok(
                questaoService.gerarRelatorioQuestoesAnuladasPorPeriodo(idUsuario, dataInicial, dataFinal, pagina, tamanho)
        );
    }

    @PostMapping()
    public ResponseEntity<QuestaoDTO> salvar(@Valid @RequestBody QuestaoModel novoQuestao){
        QuestaoDTO novoQuestaoDTO = questaoService.salvar(novoQuestao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoQuestaoDTO);
    }

    @PutMapping
    public ResponseEntity<QuestaoDTO> atualizar(@Valid @RequestBody QuestaoModel questaoExistente){
        QuestaoDTO questaoExistenteDTO = questaoService.atualizar(questaoExistente);
        return ResponseEntity.status(HttpStatus.OK).body(questaoExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody QuestaoModel questaoExistente){
        questaoService.deletar(questaoExistente);
    }
}
