package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO.RequestDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO.ResponseDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import br.senai.lab364.futurodev.reciclaville.models.DeclarationItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperDeclarationItem {

    DeclarationItem toEntity(@MappingTarget DeclarationItem entity, RequestDeclarationItemDTO request );
    ResponseDeclarationItemDTO toResponseDTO(DeclarationItem entity);
    List<ResponseDeclarationItemDTO> toResponseDTO(List<DeclarationItem> entities);
}
