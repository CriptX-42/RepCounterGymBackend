package com.criptx.repcountergym.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Exercicio  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String urlDaImagem;
    private String dataDaExecucao;
    private Integer sequenciaFixa;
    private Integer serie;

    @ManyToOne
    @JoinColumn(name="treino_id")
    @JsonIgnore
    private Treino treino;

    public Exercicio() {
    }

    public Exercicio(Integer id, String nome, String urlDaImagem, String dataDaExecucao, Integer sequenciaFixa, Integer serie, Treino treino) {
        this.id = id;
        this.nome = nome;
        this.urlDaImagem = urlDaImagem;
        this.dataDaExecucao = dataDaExecucao;
        this.sequenciaFixa = sequenciaFixa;
        this.serie = serie;
        this.treino = treino;
    }
}
