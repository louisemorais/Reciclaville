package br.senai.lab364.futurodev.reciclaville.services.Client;

import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.RequestClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.ResponseClientDTO;
import br.senai.lab364.futurodev.reciclaville.errors.badRequests.ClientBadRequestException;
import br.senai.lab364.futurodev.reciclaville.errors.notFounds.ClientNotFoundException;
import br.senai.lab364.futurodev.reciclaville.mappers.MapperClient;
import br.senai.lab364.futurodev.reciclaville.models.Client;
import br.senai.lab364.futurodev.reciclaville.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements ClientServiceInterf {

    private final ClientRepository repository;

    private final MapperClient clientMapper;


    @Override
    public List<ResponseClientDTO> findAll() {
        return clientMapper.toResponseDTO(repository.findAll());
    }

    @Override
    public ResponseClientDTO findById(Long id) {
        Client entity = repository.findById(id).orElseThrow(() ->  new ClientNotFoundException(id));
        return clientMapper.toResponseDTO(entity);
    }

    @Override
    public ResponseClientDTO creates(RequestClientDTO dto) {
        validateClient(dto);
        Client client = clientMapper.toEntity(new Client(), dto);
        return clientMapper.toResponseDTO(repository.save(client));
    }

    @Override
    public ResponseClientDTO update(Long id, RequestClientDTO dto) {
        Client client = repository.findById(id).orElseThrow(() ->  new ClientNotFoundException(id));
        validateClient(dto);
        clientMapper.toEntity(client, dto);
        return clientMapper.toResponseDTO(repository.save(client));
    }

    @Override
    public void delete(Long id) {
        Client client = repository.findById(id).orElseThrow(() ->  new ClientNotFoundException(id));
        repository.delete(client);
    }

    @Override
    public void validateClient(RequestClientDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new ClientBadRequestException("nome");
        }

        if (dto.getCnpj() == null || dto.getCnpj().isBlank()) {
            throw new ClientBadRequestException("cpf");
        }
        if (dto.getAccontable() == null || dto.getAccontable().isBlank()) {
            throw new ClientBadRequestException("accontable");
        }

        if (dto.getEconomicActivity() == null || dto.getEconomicActivity() .isBlank()) {
            throw new ClientBadRequestException("economicActivity");
        }
    }
}
