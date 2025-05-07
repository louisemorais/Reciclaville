package br.senai.lab364.futurodev.reciclaville.mappers;

import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.RequestClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.ResponseClientDTO;
import br.senai.lab364.futurodev.reciclaville.models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperClient {

    Client toEntity(@MappingTarget Client entity, RequestClientDTO request );
    ResponseClientDTO toResponseDTO(Client entity);
    List<ResponseClientDTO> toResponseDTO(List<Client> entities);
}
