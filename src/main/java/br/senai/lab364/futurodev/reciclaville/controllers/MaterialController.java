package br.senai.lab364.futurodev.reciclaville.controllers;


import br.senai.lab364.futurodev.reciclaville.dtos.materialsDTOs.RequestMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.materialsDTOs.ResponseMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.services.materials.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materials")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService service;

    @GetMapping
    public ResponseEntity<List<ResponseMaterialDTO>> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping({"{id}"})
    public ResponseEntity<ResponseMaterialDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseMaterialDTO> save(@RequestBody RequestMaterialDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.creates(dto));
    }

    @PutMapping("{id}")
    public  ResponseEntity<ResponseMaterialDTO> update( @PathVariable Long id,@RequestBody RequestMaterialDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
