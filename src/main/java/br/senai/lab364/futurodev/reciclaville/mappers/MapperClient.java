package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.RequestClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.ResponseClientDTO;
import br.senai.lab364.futurodev.reciclaville.models.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperClient {

    Client toEntity(Client entity, RequestClientDTO request);
    ResponseClientDTO responsedto(Client entity);
}
