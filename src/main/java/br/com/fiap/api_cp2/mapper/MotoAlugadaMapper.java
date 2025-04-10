package br.com.fiap.api_cp2.mapper;

import br.com.fiap.api_cp2.dto.MotoAlugadaDTO;
import br.com.fiap.api_cp2.model.MotoAlugada;
import br.com.fiap.api_cp2.model.StatusMoto;
import br.com.fiap.api_cp2.model.Entregador;

public class MotoAlugadaMapper {
    public static MotoAlugadaDTO toDTO(MotoAlugada m) {
        MotoAlugadaDTO dto = new MotoAlugadaDTO();
        dto.id = m.getId();
        dto.modelo = m.getModelo();
        dto.placa = m.getPlaca();
        dto.status = m.getStatus().name();
        dto.dataAluguel = m.getDataAluguel();
        dto.quilometragem = m.getQuilometragem();
        dto.entregadorId = m.getEntregador() != null ? m.getEntregador().getId() : null;
        return dto;
    }

    public static MotoAlugada toEntity(MotoAlugadaDTO dto, Entregador entregador) {
        MotoAlugada m = new MotoAlugada();
        m.setId(dto.id);
        m.setModelo(dto.modelo);
        m.setPlaca(dto.placa);
        m.setStatus(StatusMoto.valueOf(dto.status));
        m.setDataAluguel(dto.dataAluguel);
        m.setQuilometragem(dto.quilometragem);
        m.setEntregador(entregador);
        return m;
    }
}