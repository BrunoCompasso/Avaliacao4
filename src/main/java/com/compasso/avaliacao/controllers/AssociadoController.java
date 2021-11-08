package com.compasso.avaliacao.controllers;

import com.compasso.avaliacao.dto.AssociadoDTO;
import com.compasso.avaliacao.dto.AssociadoFormDTO;
import com.compasso.avaliacao.services.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

        @Autowired
        private AssociadoService service;

        @PostMapping
        public ResponseEntity<AssociadoDTO> salvar(@RequestBody AssociadoFormDTO body) {
            AssociadoDTO state = this.service.salvar(body);
            return ResponseEntity.ok(state);
        }

        @GetMapping
        public ResponseEntity<List<AssociadoDTO>> listar(@RequestParam(value = "cargo", required = false) String cargo){
            return ResponseEntity.ok(this.service.listar(cargo));
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<AssociadoDTO> procurar (@RequestParam(value = "id", required = true) Long id){
            return ResponseEntity.ok(this.service.procurar(id));
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<AssociadoDTO> atualizar (@RequestParam(value = "id", required = true) Long id,@RequestBody AssociadoFormDTO body){
            return ResponseEntity.ok(this.service.atualizar(id,body));
        }

        @DeleteMapping(path = "/{id}")
        public ResponseEntity<AssociadoDTO> remover (@RequestParam(value = "id", required = true) Long id){
            this.service.remover(id);
            return ResponseEntity.ok().build();
        }

        @PostMapping(path = "/{id}/{id}")
        public ResponseEntity<AssociadoDTO> vincularPartido (@RequestParam(value = "id", required = true) Long idAssociado,@RequestParam(value = "id", required = true) Long idPartido){
            return ResponseEntity.ok(this.service.vincularPartido(idAssociado,idPartido));
        }

}