package br.com.fiap.api_cp2.controller;

import br.com.fiap.api_cp2.dto.EntregadorDTO;
import br.com.fiap.api_cp2.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {
    @Autowired
    private EntregadorService service;

    @GetMapping
    public CollectionModel<EntityModel<EntregadorDTO>> listar() {
        List<EntityModel<EntregadorDTO>> entregadores = service.listarTodos().stream()
                .map(e -> EntityModel.of(e, linkTo(methodOn(EntregadorController.class).listar()).withSelfRel()))
                .toList();
        return CollectionModel.of(entregadores);
    }

    @PostMapping
    public ResponseEntity<EntregadorDTO> criar(@RequestBody @Valid EntregadorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntregadorDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EntregadorDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}