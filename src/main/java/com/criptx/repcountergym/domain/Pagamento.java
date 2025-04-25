package com.criptx.repcountergym.domain;

import com.criptx.repcountergym.utils.ModoPagamento;
import com.criptx.repcountergym.utils.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal valor;

    private LocalDateTime dataPagamento;
    private ModoPagamento metodo;
    private StatusPagamento status;
    private String descricao;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;
}
