package br.senai.lab364.futurodev.reciclaville.controllers;


import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.RequestClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.ResponseClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.MaterialsDTO.RequestMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.MaterialsDTO.ResponseMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.services.Client.ClientService;
import br.senai.lab364.futurodev.reciclaville.services.Material.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materials")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService service;

    @GetMapping
    public List<ResponseMaterialDTO> getAllClients() {

        return service.findAll();
    }
    @GetMapping({"{id}"})
    public ResponseMaterialDTO findById(@PathVariable Long id) {

        return service.findById(id);
    }

    @PostMapping
    public ResponseMaterialDTO save(@RequestBody RequestMaterialDTO dto) {

        return service.creates(dto);
    }

    @PutMapping("{id}")
    public  ResponseMaterialDTO update( @PathVariable Long id,@RequestBody RequestMaterialDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }
}
