package com.criptx.repcountergym.controller;

import com.criptx.repcountergym.domain.Cliente;
import com.criptx.repcountergym.domain.Treino;
import com.criptx.repcountergym.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/treinos")
public class TreinoController {
    @Autowired
    private TreinoService treinoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Treino> listAll(@PathVariable Integer id) {
        Treino treinoFind = treinoService.findById(id);
        return ResponseEntity.ok().body(treinoFind);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Treino treino, @PathVariable Integer id) {
        treino.setId(id);
        treinoService.update(treino);
        return ResponseEntity.noContent().build();
    }
}
