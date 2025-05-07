package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.MaterialsDTO.RequestMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.MaterialsDTO.ResponseMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.models.Material;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperMaterial {

    Material toEntity(Material entity, RequestMaterialDTO request);
    ResponseMaterialDTO responsedto(Material entity);
}
