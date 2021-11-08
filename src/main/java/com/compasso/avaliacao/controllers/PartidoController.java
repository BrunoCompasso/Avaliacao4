package com.compasso.avaliacao.controllers;


import com.compasso.avaliacao.dto.PartidoDTO;
import com.compasso.avaliacao.dto.PartidoFormDTO;
import com.compasso.avaliacao.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partido")
public class PartidoController {

        @Autowired
        private PartidoService service;


        @PostMapping
        public ResponseEntity<PartidoDTO> salvar(@RequestBody PartidoFormDTO body) {
            PartidoDTO state = this.service.salvar(body);
            return ResponseEntity.ok(state);
        }

        @GetMapping
        public ResponseEntity<List<PartidoDTO>> listar(@RequestParam(value = "ideologia", required = false) String ideologia){
            return ResponseEntity.ok(this.service.listar(ideologia));
        }

        @GetMapping(path = "/{id}/associados")
        public ResponseEntity<PartidoDTO> listarAssociados(@RequestParam(value = "id", required = true) Long id){
            return ResponseEntity.ok(this.service.listarAssociados(id));
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<PartidoDTO> procurar (@RequestParam(value = "id", required = true) Long id){
            return ResponseEntity.ok(this.service.procurar(id));
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<PartidoDTO> atualizar (@RequestParam(value = "id", required = true) Long id,@RequestBody PartidoFormDTO body){
            return ResponseEntity.ok(this.service.atualizar(id,body));
        }

        @DeleteMapping(path = "/{id}")
        public ResponseEntity<PartidoDTO> remover (@RequestParam(value = "id", required = true) Long id){
            this.service.remover(id);
            return ResponseEntity.ok().build();
        }

    }

