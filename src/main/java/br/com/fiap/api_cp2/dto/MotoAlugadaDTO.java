package br.com.fiap.api_cp2.dto;

import java.time.LocalDate;

public class MotoAlugadaDTO {
    public Long id;
    public String modelo;
    public String placa;
    public String status;
    public LocalDate dataAluguel;
    public Double quilometragem;
    public Long entregadorId;
}