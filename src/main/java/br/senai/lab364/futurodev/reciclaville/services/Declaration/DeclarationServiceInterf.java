package br.senai.lab364.futurodev.reciclaville.services.Declaration;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import br.senai.lab364.futurodev.reciclaville.models.DeclarationItem;

import java.util.List;

public interface DeclarationServiceInterf {
    List<ResponseDeclarationDTO> findAll();
    ResponseDeclarationDTO findById(Long id);
    ResponseDeclarationDTO creates(RequestDeclarationDTO dto);
    void delete(Long id);
    void datesValidation (RequestDeclarationDTO dto, Declaration declaration);
    void clientsValidation (RequestDeclarationDTO dto);
    void materialValidation (DeclarationItem item);
    void toneladasValidation (DeclarationItem item);
    void totalTons (Declaration declaration);
    void totalCompensation (Declaration declaration);
}
