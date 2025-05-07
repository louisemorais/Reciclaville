package br.senai.lab364.futurodev.reciclaville.services.Client;

import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.RequestClientDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO.ResponseClientDTO;
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
        Client entity = repository.findById(id).orElse(null);
        return clientMapper.toResponseDTO(entity);
    }

    @Override
    public ResponseClientDTO creates(RequestClientDTO dto) {
        Client client = clientMapper.toEntity(new Client(), dto);
        return clientMapper.toResponseDTO(repository.save(client));
    }

    @Override
    public ResponseClientDTO update(Long id, RequestClientDTO dto) {
        Client client = repository.findById(id).orElse(null);
        clientMapper.toEntity(client, dto);
        return clientMapper.toResponseDTO(repository.save(client));
    }

    @Override
    public void delete(Long id) {
        Client client = repository.findById(id).orElse(null);
        repository.delete(client);
    }
}
