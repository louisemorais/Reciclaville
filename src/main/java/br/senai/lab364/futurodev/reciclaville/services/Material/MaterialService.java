package br.senai.lab364.futurodev.reciclaville.services.Material;

import br.senai.lab364.futurodev.reciclaville.dtos.MaterialsDTO.RequestMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.MaterialsDTO.ResponseMaterialDTO;
import br.senai.lab364.futurodev.reciclaville.mappers.MapperMaterial;
import br.senai.lab364.futurodev.reciclaville.models.Material;
import br.senai.lab364.futurodev.reciclaville.repositories.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialService implements MaterialServiceInterf{

    private final MaterialRepository repository;
    private final MapperMaterial materialMapper;

    @Override
    public List<ResponseMaterialDTO> findAll() {
        return materialMapper.toResponseDTO(repository.findAll());
    }

    @Override
    public ResponseMaterialDTO findById(Long id) {
        Material entity = repository.findById(id).orElseThrow();
        return materialMapper.toResponseDTO(entity);
    }

    @Override
    public ResponseMaterialDTO creates(RequestMaterialDTO dto) {
        Material material = materialMapper.toEntity(new Material(), dto);
        return materialMapper.toResponseDTO(repository.save(material));
    }

    @Override
    public ResponseMaterialDTO update(Long id, RequestMaterialDTO dto) {
        Material material = repository.findById(id).orElseThrow();
        materialMapper.toEntity(material, dto);
        return materialMapper.toResponseDTO(repository.save(material));
    }

    @Override
    public void delete(Long id) {
        Material material = repository.findById(id).orElseThrow();
        repository.delete(material);
    }
}
