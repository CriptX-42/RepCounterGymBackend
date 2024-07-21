package com.criptx.repcountergym.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Treino implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeDeTreino;
    private String nomeDoTreinador;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private String dataInicio;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private String dataFim;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    @JsonIgnore
    private Cliente cliente;

    public Treino() {
    }

    public Treino(Integer id, String nomeDeTreino, String nomeDoTreinador, String dataInicio, String dataFim) {
        this.id = id;
        this.nomeDeTreino = nomeDeTreino;
        this.nomeDoTreinador = nomeDoTreinador;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}
