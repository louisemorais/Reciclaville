package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.declarationItemDTOs.RequestDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.declarationItemDTOs.ResponseDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.models.DeclarationItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring",uses = {MapperMaterial.class})
public interface MapperDeclarationItem {

    DeclarationItem toEntity(@MappingTarget DeclarationItem entity, RequestDeclarationItemDTO request );

    @Mapping(source = "declaration.id", target = "declarationId")
    @Mapping(source = "material.compensationOfPercentage", target = "compensationOfPercentage")
    ResponseDeclarationItemDTO toResponseDTO(DeclarationItem entity);

    List<ResponseDeclarationItemDTO> toResponseDTO(List<DeclarationItem> entities);
}
