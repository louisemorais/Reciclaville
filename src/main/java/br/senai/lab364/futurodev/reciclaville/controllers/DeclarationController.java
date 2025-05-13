package br.senai.lab364.futurodev.reciclaville.controllers;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.services.Declaration.DeclarationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("declaration")
@RequiredArgsConstructor
public class DeclarationController {
    private final DeclarationService service;

    @GetMapping
    public ResponseEntity<List<ResponseDeclarationDTO> > getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    @GetMapping({"{id}"})
    public ResponseEntity<ResponseDeclarationDTO> findById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseDeclarationDTO> save(@RequestBody RequestDeclarationDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.creates(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
