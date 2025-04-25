package com.criptx.repcountergym.services;

import com.criptx.repcountergym.domain.Cliente;
import com.criptx.repcountergym.domain.Pagamento;
import com.criptx.repcountergym.domain.Treino;
import com.criptx.repcountergym.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> list() {
        return pagamentoRepository.findAll();
    }

    public Pagamento findById(Integer id) {
        return pagamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    public void delete(Integer id) {
         pagamentoRepository.deleteById(id);
    }

    public Pagamento save(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento update(Pagamento pagamento) {
        Pagamento newCliente = findById(pagamento.getId());
        updateData(newCliente, pagamento);
        return pagamentoRepository.save(newCliente);
    }

    public void updateData(Pagamento newObj, Pagamento pagamentoAntigo) {
         pagamentoAntigo.toBuilder().dataPagamento(newObj.getDataPagamento())
                 .clienteId(newObj.getClienteId())
                 .valor(newObj.getValor())
                 .status(newObj.getStatus())
                 .metodo(newObj.getMetodo())
                 .descricao(newObj.getDescricao())
                 .build();
    }

}
