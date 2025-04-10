package br.com.fiap.api_cp2.service;

import br.com.fiap.api_cp2.dto.MotoAlugadaDTO;
import br.com.fiap.api_cp2.mapper.MotoAlugadaMapper;
import br.com.fiap.api_cp2.model.Entregador;
import br.com.fiap.api_cp2.model.MotoAlugada;
import br.com.fiap.api_cp2.repository.EntregadorRepository;
import br.com.fiap.api_cp2.repository.MotoAlugadaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoAlugadaService {
    @Autowired
    private MotoAlugadaRepository motoRepo;
    @Autowired
    private EntregadorRepository entregadorRepo;

    public List<MotoAlugadaDTO> listarTodas() {
        return motoRepo.findAll().stream().map(MotoAlugadaMapper::toDTO).toList();
    }

    public MotoAlugadaDTO salvar(MotoAlugadaDTO dto) {
        Entregador entregador = entregadorRepo.findById(dto.entregadorId).orElseThrow();
        MotoAlugada moto = MotoAlugadaMapper.toEntity(dto, entregador);
        moto = motoRepo.save(moto);
        return MotoAlugadaMapper.toDTO(moto);
    }

    public MotoAlugadaDTO atualizar(Long id, MotoAlugadaDTO dto) {
        MotoAlugada existente = motoRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Moto não encontrada"));
        Entregador entregador = entregadorRepo.findById(dto.entregadorId).orElseThrow();
        MotoAlugada atualizada = MotoAlugadaMapper.toEntity(dto, entregador);
        atualizada.setId(id);
        atualizada = motoRepo.save(atualizada);
        return MotoAlugadaMapper.toDTO(atualizada);
    }

    public void deletar(Long id) {
        if (!motoRepo.existsById(id)) {
            throw new EntityNotFoundException("Moto não encontrada");
        }
        motoRepo.deleteById(id);
    }
}