package br.com.fiap.api_cp2.service;

import br.com.fiap.api_cp2.dto.EntregadorDTO;
import br.com.fiap.api_cp2.mapper.EntregadorMapper;
import br.com.fiap.api_cp2.model.Entregador;
import br.com.fiap.api_cp2.repository.EntregadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository repo;

    public List<EntregadorDTO> listarTodos() {
        return repo.findAll().stream().map(EntregadorMapper::toDTO).toList();
    }

    public EntregadorDTO salvar(EntregadorDTO dto) {
        Entregador e = EntregadorMapper.toEntity(dto);
        e = repo.save(e);
        return EntregadorMapper.toDTO(e);
    }

    public EntregadorDTO atualizar(Long id, EntregadorDTO dto) {
        Entregador existente = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Entregador não encontrado"));
        Entregador atualizado = EntregadorMapper.toEntity(dto);
        atualizado.setId(id);
        atualizado = repo.save(atualizado);
        return EntregadorMapper.toDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Entregador não encontrado");
        }
        repo.deleteById(id);
    }
}