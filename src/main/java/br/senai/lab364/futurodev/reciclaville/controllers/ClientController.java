package br.senai.lab364.futurodev.reciclaville.controllers;


import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.RequestClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.ResponseClientDTO;
import br.senai.lab364.futurodev.reciclaville.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public List<ResponseClientDTO> getAllClients() {
        return service.findAll();
    }
    @GetMapping({"{id}"})
    public ResponseClientDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseClientDTO save(@RequestBody RequestClientDTO dto) {
        return service.creates(dto);
    }

    @PutMapping("{id}")
    public  ResponseClientDTO update( @PathVariable Long id,@RequestBody RequestClientDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
