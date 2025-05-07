package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.models.Client;
import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperDeclaration {

    Client toEntity(Declaration entity, RequestDeclarationDTO request);
    ResponseDeclarationDTO responsedto(Declaration entity);
}
