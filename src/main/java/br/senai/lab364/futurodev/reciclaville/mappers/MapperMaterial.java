package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.materialsDTOs.RequestMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.materialsDTOs.ResponseMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.models.Material;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperMaterial {
    Material toEntity(@MappingTarget Material entity, RequestMaterialDTO request );
    ResponseMaterialDTO toResponseDTO(Material entity);
    List<ResponseMaterialDTO> toResponseDTO(List<Material> entities);
}
