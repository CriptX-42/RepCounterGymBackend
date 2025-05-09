package com.criptx.repcountergym.controller;

import com.criptx.repcountergym.domain.Cliente;
import com.criptx.repcountergym.dto.ClienteDTO;
import com.criptx.repcountergym.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> list = clienteService.list();
        List<ClienteDTO> dto = list.stream().map(ClienteDTO::new).toList();
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteDTO> listAll(@PathVariable Integer id) {
        Cliente clientFind = clienteService.findById(id);
        ClienteDTO dto = new ClienteDTO(clientFind);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Cliente cliente) {
        Cliente clientFind = clienteService.save(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(clientFind.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Cliente cliente, @PathVariable Integer id) {
        cliente.setId(id);
        clienteService.update(cliente);

        return ResponseEntity.noContent().build();
    }
}
