package com.criptx.repcountergym.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double altura;
    private Double peso;
    private Double idade;
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Treino> treinos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Integer id, String nome, Double altura, Double peso, Double idade, String email) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.email = email;
    }
}
