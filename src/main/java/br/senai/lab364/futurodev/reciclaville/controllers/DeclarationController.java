package br.senai.lab364.futurodev.reciclaville.controllers;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.services.Declaration.DeclarationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("declaration")
@RequiredArgsConstructor
public class DeclarationController {
    private final DeclarationService service;

    @GetMapping
    public List<ResponseDeclarationDTO> getAllClients() {

        return service.findAll();
    }
    @GetMapping({"{id}"})
    public ResponseDeclarationDTO findById(@PathVariable Long id) {

        return service.findById(id);
    }

    @PostMapping
    public ResponseDeclarationDTO save(@RequestBody RequestDeclarationDTO dto) {

        return service.creates(dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }
}
