package br.senai.lab364.futurodev.reciclaville.controllers;


import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.RequestClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.ResponseClientDTO;
import br.senai.lab364.futurodev.reciclaville.services.Client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public ResponseEntity<List<ResponseClientDTO>> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping({"{id}"})
    public ResponseEntity<ResponseClientDTO> findById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseClientDTO> save(@RequestBody RequestClientDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.creates(dto));
    }

    @PutMapping("{id}")
    public  ResponseEntity<ResponseClientDTO> update( @PathVariable Long id,@RequestBody RequestClientDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
