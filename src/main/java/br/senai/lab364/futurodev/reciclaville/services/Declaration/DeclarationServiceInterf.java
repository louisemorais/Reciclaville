package br.senai.lab364.futurodev.reciclaville.services.Declaration;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;

import java.util.List;

public interface DeclarationServiceInterf {
    List<ResponseDeclarationDTO> findAll();
    ResponseDeclarationDTO findById(Long id);
    ResponseDeclarationDTO creates(RequestDeclarationDTO dto);
    void delete(Long id);
}
