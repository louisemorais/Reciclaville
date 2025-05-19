package br.senai.lab364.futurodev.reciclaville.services.clients;

import br.senai.lab364.futurodev.reciclaville.dtos.clientsDTO.RequestClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.clientsDTO.ResponseClientDTO;

import java.util.List;

public interface ClientServiceInterf {
    List<ResponseClientDTO> findAll();
    ResponseClientDTO findById(Long id);
    ResponseClientDTO creates(RequestClientDTO dto);
    ResponseClientDTO update(Long id, RequestClientDTO dto);
    void delete(Long id);
    void validateClient(RequestClientDTO dto);
}
