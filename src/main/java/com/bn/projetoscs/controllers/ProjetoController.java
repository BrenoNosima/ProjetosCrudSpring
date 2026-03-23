package com.bn.projetoscs.controllers;

import com.bn.projetoscs.models.ProjetoModel;
import com.bn.projetoscs.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoModel> salvar(@RequestBody ProjetoModel projetoModel) {
        ProjetoModel request = projetoService.criar(projetoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/projetos/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> listar() {
        List<ProjetoModel> request = projetoService.listar();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoModel> procurarPorId(@PathVariable Long id) {
        ProjetoModel request = projetoService.procurarPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        projetoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
