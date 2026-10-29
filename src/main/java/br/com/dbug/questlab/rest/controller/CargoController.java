package br.com.dbug.questlab.rest.controller;

import br.com.dbug.questlab.model.CargoModel;
import br.com.dbug.questlab.rest.dto.CargoDTO;
import br.com.dbug.questlab.service.CargoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    CargoService cargoService;

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> obterPorId(@PathVariable int id){
        CargoDTO cargoDTO = cargoService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(cargoDTO);
    }

    @GetMapping()
    public ResponseEntity<List<CargoDTO>> obterTodos(){
        List<CargoDTO> cargoDTOList = cargoService.obterTodos();
        return ResponseEntity.ok(cargoDTOList);
    }

    @PostMapping()
    public ResponseEntity<CargoDTO> salvar(@Valid @RequestBody CargoModel novoCargo){
        CargoDTO novoCargoDTO = cargoService.salvar(novoCargo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCargoDTO);
    }

    @PutMapping
    public ResponseEntity<CargoDTO> atualizar(@Valid @RequestBody CargoModel cargoExistente){
        CargoDTO cargoExistenteDTO = cargoService.atualizar(cargoExistente);
        return ResponseEntity.status(HttpStatus.OK).body(cargoExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody CargoModel cargoExistente){
        cargoService.deletar(cargoExistente);
    }
}
