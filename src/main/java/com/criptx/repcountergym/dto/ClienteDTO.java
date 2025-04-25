package com.criptx.repcountergym.dto;

import com.criptx.repcountergym.domain.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Integer id;
    private String nome;
    private Double altura;
    private Double peso;
    private Double idade;
    private String email;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.altura = cliente.getAltura();
        this.peso = cliente.getPeso();
        this.idade = cliente.getIdade();
        this.email = cliente.getEmail();
    }
}
