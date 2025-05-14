package br.senai.lab364.futurodev.reciclaville.services.Declaration;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.mappers.MapperDeclaration;
import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import br.senai.lab364.futurodev.reciclaville.models.DeclarationItem;
import br.senai.lab364.futurodev.reciclaville.models.Material;
import br.senai.lab364.futurodev.reciclaville.repositories.ClientRepository;
import br.senai.lab364.futurodev.reciclaville.repositories.DeclarationRepository;
import br.senai.lab364.futurodev.reciclaville.repositories.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class DeclarationService implements DeclarationServiceInterf {

    private final DeclarationRepository repository;
    private final MaterialRepository repositorymaterial;
    private final ClientRepository repositoryclient;
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
        /////////////////////////////////////////////////
        if (dto.client().getId() == null || !repositoryclient.existsById(dto.client().getId())) {
            throw new EntityNotFoundException("Cliente não encontrado com ID: " + dto.client().getId());
        }

        ///alterações com datas
        declaration.setDateOfDeclaration(LocalDate.now());

        if(dto.startDate().isAfter(dto.endDate()) || dto.endDate().isBefore(dto.startDate())) {
            throw new  DataIntegrityViolationException("as datas estão erradas");
        }


        ///Alterações relacionados ao materiais ou cálculos
        double totalTons= 0.0;
        double  totalCompens = 0.0;
        for(DeclarationItem item : declaration.getItens()){
            item.setDeclaration(declaration);

            /// Validações
            if (item.getTonsDeclared() <= 0) {
                throw new IllegalArgumentException(
                        "Toneladas declaradas devem ser maiores que zero (Item ID: " + item.getId() + ")."
                );
            }

            ///material
            Long materialId = item.getMaterial().getId();
            Material material = repositorymaterial.findById(materialId).orElseThrow(() ->
                    new RuntimeException("Material não encontrado com ID: " + materialId)
            );

            item.setMaterial(material);
            item.setPercentage(item.getMaterial().getCompensationOfPercentage());
            /////////////////////////////////////////////////


            double percentCompens = item.getMaterial().getCompensationOfPercentage();
            double compens = item.getTonsDeclared() * (percentCompens / 100);
            item.setTonsCompensation(compens);

            totalTons += item.getTonsDeclared();
            totalCompens += compens;
        }
        declaration.setMaterialTotal(totalTons);
        declaration.setCompensationTotal(totalCompens);


        /////////////////////////////////////////////////

        return declarationMapper.toResponseDTO(repository.save(declaration));
    }

    @Override
    public void delete(Long id) {
        Declaration declaration = repository.findById(id).orElse(null);
        repository.delete(declaration);
    }
}
