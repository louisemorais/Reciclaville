package br.senai.lab364.futurodev.reciclaville.services;

import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.RequestClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.ResponseClientDTO;

import java.util.List;

public interface ClientServiceInterf {
    List<ResponseClientDTO> findAll();
    ResponseClientDTO findById(Long id);
    ResponseClientDTO creates(RequestClientDTO dto);
    ResponseClientDTO update(Long id, RequestClientDTO dto);
    void delete(Long id);
}
