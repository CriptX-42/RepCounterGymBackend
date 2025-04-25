package com.criptx.repcountergym.controller;

import com.criptx.repcountergym.domain.Cliente;
import com.criptx.repcountergym.domain.Pagamento;
import com.criptx.repcountergym.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> list = pagamentoService.list();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pagamento> listAll(@PathVariable Integer id) {
        Pagamento pagamentoServiceById = pagamentoService.findById(id);
        return ResponseEntity.ok().body(pagamentoServiceById);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pagamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Pagamento cliente) {
        Pagamento pagamento = pagamentoService.save(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pagamento.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Pagamento pagamento, @PathVariable Integer id) {
        pagamento.setId(id);
        pagamentoService.update(pagamento);

        return ResponseEntity.noContent().build();
    }
}
