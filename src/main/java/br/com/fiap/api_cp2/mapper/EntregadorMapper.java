package br.com.fiap.api_cp2.mapper;

import br.com.fiap.api_cp2.dto.EntregadorDTO;
import br.com.fiap.api_cp2.model.Entregador;
import br.com.fiap.api_cp2.model.StatusEntregador;

public class EntregadorMapper {
    public static EntregadorDTO toDTO(Entregador e) {
        EntregadorDTO dto = new EntregadorDTO();
        dto.id = e.getId();
        dto.nome = e.getNome();
        dto.cpf = e.getCpf();
        dto.telefone = e.getTelefone();
        dto.cnh = e.getCnh();
        dto.status = e.getStatus().name();
        dto.dataCadastro = e.getDataCadastro();
        return dto;
    }

    public static Entregador toEntity(EntregadorDTO dto) {
        Entregador e = new Entregador();
        e.setId(dto.id);
        e.setNome(dto.nome);
        e.setCpf(dto.cpf);
        e.setTelefone(dto.telefone);
        e.setCnh(dto.cnh);
        e.setStatus(StatusEntregador.valueOf(dto.status));
        e.setDataCadastro(dto.dataCadastro);
        return e;
    }
}