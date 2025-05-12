package br.senai.lab364.futurodev.reciclaville.services.Declaration;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO.ResponseDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.mappers.MapperDeclaration;
import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import br.senai.lab364.futurodev.reciclaville.models.DeclarationItem;
import br.senai.lab364.futurodev.reciclaville.repositories.DeclarationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeclarationService implements DeclarationServiceInterf {

    private final DeclarationRepository repository;
    private final MapperDeclaration declarationMapper;


    @Override
    public List<ResponseDeclarationDTO> findAll() {
        return declarationMapper.toResponseDTO(repository.findAll());
    }

    @Override
    public ResponseDeclarationDTO findById(Long id) {
        Declaration declaration = repository.findById(id).orElse(null);
        return declarationMapper.toResponseDTO(declaration);
    }

    @Override
    public ResponseDeclarationDTO creates(RequestDeclarationDTO dto) {
        Declaration declaration = declarationMapper.toEntity(new Declaration(),dto);
        return declarationMapper.toResponseDTO(repository.save(declaration));
    }

    @Override
    public void delete(Long id) {
        Declaration declaration = repository.findById(id).orElse(null);
        repository.delete(declaration);
    }
}
