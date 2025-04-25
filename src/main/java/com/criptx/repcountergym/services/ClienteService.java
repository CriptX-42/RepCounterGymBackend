package com.criptx.repcountergym.services;

import com.criptx.repcountergym.domain.Cliente;
import com.criptx.repcountergym.domain.Treino;
import com.criptx.repcountergym.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void delete(Integer id) {
         clienteRepository.deleteById(id);
    }

    public Cliente save(Cliente cliente){
        for (Treino treino: cliente.getTreinos()) {
            treino.setCliente(cliente);
        }
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        Cliente newCliente = findById(cliente.getId());
        updateData(newCliente, cliente);
        return clienteRepository.save(newCliente);
    }

    public void updateData(Cliente newObj, Cliente cliente) {
         cliente.toBuilder()
                .altura(newObj.getAltura())
                .email(newObj.getEmail())
                .idade(newObj.getIdade())
                .peso(newObj.getPeso())
                .nome(newObj.getNome())
                .build();
    }

}
