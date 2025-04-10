package br.com.fiap.api_cp2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Entregador {
    @Id @GeneratedValue
    private Long id;

    @NotBlank
    private String nome;

    @Pattern(regexp = "\\d{11}")
    private String cpf;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}")
    private String telefone;

    @NotBlank
    private String cnh;

    @Enumerated(EnumType.STRING)
    private StatusEntregador status;

    @PastOrPresent
    private LocalDate dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public StatusEntregador getStatus() {
        return status;
    }

    public void setStatus(StatusEntregador status) {
        this.status = status;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}