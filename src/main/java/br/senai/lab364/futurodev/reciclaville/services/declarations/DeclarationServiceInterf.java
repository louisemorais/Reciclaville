package br.senai.lab364.futurodev.reciclaville.services.declarations;

import br.senai.lab364.futurodev.reciclaville.dtos.declarationDTOs.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.declarationDTOs.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import br.senai.lab364.futurodev.reciclaville.models.DeclarationItem;

import java.util.List;

public interface DeclarationServiceInterf {
    List<ResponseDeclarationDTO> findAll();
    ResponseDeclarationDTO findById(Long id);
    ResponseDeclarationDTO creates(RequestDeclarationDTO dto);
    void delete(Long id);
    void validateDates(RequestDeclarationDTO dto, Declaration declaration);
    void validateClient(RequestDeclarationDTO dto);
    void validateMaterial(DeclarationItem item);
    void validateTons(DeclarationItem item);
    void totalTons (Declaration declaration);
    void totalCompensation (Declaration declaration);
}
