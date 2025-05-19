package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.declarationDTOs.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.declarationDTOs.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring",uses = {MapperDeclarationItem.class})
public interface MapperDeclaration {

    Declaration toEntity(@MappingTarget Declaration entity, RequestDeclarationDTO request );

    @AfterMapping
    default void afterMapping(@MappingTarget Declaration declaration, RequestDeclarationDTO dto) {
        if (declaration.getItens() != null) {
            declaration.getItens().forEach(item -> item.setDeclaration(declaration));
        }
    }
    ResponseDeclarationDTO toResponseDTO(Declaration entity);
    List<ResponseDeclarationDTO> toResponseDTO(List<Declaration> entities);
}
