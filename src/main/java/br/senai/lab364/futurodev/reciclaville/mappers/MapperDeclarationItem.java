package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO.RequestDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO.ResponseDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.models.DeclarationItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperDeclarationItem {

    DeclarationItem toEntity(DeclarationItem entity, RequestDeclarationItemDTO request);
    ResponseDeclarationItemDTO responsedto(DeclarationItem entity);
}
