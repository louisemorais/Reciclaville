package br.senai.lab364.futurodev.reciclaville.services.materials;

import br.senai.lab364.futurodev.reciclaville.dtos.materialsDTOs.RequestMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.materialsDTOs.ResponseMaterialDTO;

import java.util.List;

public interface MaterialServiceInterf {
    List<ResponseMaterialDTO> findAll();
    ResponseMaterialDTO findById(Long id);
    ResponseMaterialDTO creates(RequestMaterialDTO dto);
    ResponseMaterialDTO update(Long id, RequestMaterialDTO dto);
    void delete(Long id);
    void validateMaterial(RequestMaterialDTO dto );
}
