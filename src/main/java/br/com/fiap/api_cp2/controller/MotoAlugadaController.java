package br.com.fiap.api_cp2.controller;

import br.com.fiap.api_cp2.dto.MotoAlugadaDTO;
import br.com.fiap.api_cp2.service.MotoAlugadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/motos")
public class MotoAlugadaController {
    @Autowired
    private MotoAlugadaService service;

    @GetMapping
    public CollectionModel<EntityModel<MotoAlugadaDTO>> listar() {
        List<EntityModel<MotoAlugadaDTO>> motos = service.listarTodas().stream()
                .map(m -> EntityModel.of(m, linkTo(methodOn(MotoAlugadaController.class).listar()).withSelfRel()))
                .toList();
        return CollectionModel.of(motos);
    }

    @PostMapping
    public ResponseEntity<MotoAlugadaDTO> criar(@RequestBody @Valid MotoAlugadaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoAlugadaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MotoAlugadaDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
