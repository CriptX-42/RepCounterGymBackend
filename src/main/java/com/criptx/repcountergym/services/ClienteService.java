package com.criptx.repcountergym.services;

import com.criptx.repcountergym.domain.Cliente;
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
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        Cliente newCliente = findById(cliente.getId());
        updateData(newCliente, cliente);
        return clienteRepository.save(newCliente);
    }

    public void updateData(Cliente newObj, Cliente cliente) {
        newObj.setAltura(cliente.getAltura());
        newObj.setEmail(cliente.getEmail());
        newObj.setIdade(cliente.getIdade());
        newObj.setPeso(cliente.getPeso());
        newObj.setNome(cliente.getNome());
    }

}
