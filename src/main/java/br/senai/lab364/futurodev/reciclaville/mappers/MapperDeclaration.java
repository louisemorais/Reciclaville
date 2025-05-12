package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperDeclaration {

    Declaration toEntity(@MappingTarget Declaration entity, RequestDeclarationDTO request );
    ResponseDeclarationDTO toResponseDTO(Declaration entity);
    List<ResponseDeclarationDTO> toResponseDTO(List<Declaration> entities);
}
