package br.senai.lab364.futurodev.reciclaville.services.declarations;

import br.senai.lab364.futurodev.reciclaville.dtos.declarationDTOs.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.declarationDTOs.ResponseDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.errors.badRequests.DeclarationBadRequestException;
import br.senai.lab364.futurodev.reciclaville.errors.notFounds.ClientNotFoundException;
import br.senai.lab364.futurodev.reciclaville.errors.notFounds.DeclarationNotFoundException;
import br.senai.lab364.futurodev.reciclaville.errors.notFounds.MaterialNotFoundException;
import br.senai.lab364.futurodev.reciclaville.mappers.MapperDeclaration;
import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import br.senai.lab364.futurodev.reciclaville.models.DeclarationItem;
import br.senai.lab364.futurodev.reciclaville.models.Material;
import br.senai.lab364.futurodev.reciclaville.repositories.ClientRepository;
import br.senai.lab364.futurodev.reciclaville.repositories.DeclarationRepository;
import br.senai.lab364.futurodev.reciclaville.repositories.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class DeclarationService implements DeclarationServiceInterf {

    private final DeclarationRepository repository;
    private final MaterialRepository repositoryMaterial;
    private final ClientRepository repositoryClient;
    private final MapperDeclaration declarationMapper;



    @Override
    public List<ResponseDeclarationDTO> findAll() {
        return declarationMapper.toResponseDTO(repository.findAll());
    }

    @Override
    public ResponseDeclarationDTO findById(Long id) {
        Declaration declaration = repository.findById(id).orElseThrow(() ->  new DeclarationNotFoundException(id));
        return declarationMapper.toResponseDTO(declaration);
    }

    @Override
    public ResponseDeclarationDTO creates(RequestDeclarationDTO dto) {
        Declaration declaration = declarationMapper.toEntity(new Declaration(),dto);

        validateClient(dto);
        validateDates(dto, declaration);
        totalTons(declaration);
        totalCompensation(declaration);

        return declarationMapper.toResponseDTO(repository.save(declaration));
    }

    @Override
    public void delete(Long id) {
        Declaration declaration = repository.findById(id).orElseThrow(() ->  new DeclarationNotFoundException(id));
        repository.delete(declaration);
    }

    ////////////////////////////////////// VALIDAÇÕES //////////////////////////////////////////////////////////////////

    @Override
    public void validateDates(RequestDeclarationDTO dto, Declaration declaration) {
        declaration.setDateOfDeclaration(LocalDate.now());

        if(dto.startDate().isAfter(dto.endDate())||dto.endDate().isBefore(dto.startDate()))
            throw new DeclarationBadRequestException("Your date");
    }

    @Override
    public void validateClient(RequestDeclarationDTO dto) {
        Long idClient=dto.client().getId();
        if (idClient == null || !repositoryClient.existsById(idClient)) {
            throw new ClientNotFoundException(idClient);
        }
    }

    @Override
    public void validateMaterial(DeclarationItem item) {
        Long materialId = item.getMaterial().getId();
        Material material = repositoryMaterial.findById(materialId).orElseThrow(()
                ->  new MaterialNotFoundException(materialId));
        item.setMaterial(material);
    }

    @Override
    public void validateTons(DeclarationItem item) {
        if (item.getTonsDeclared() <= 0) {
            throw new DeclarationBadRequestException(item.getTonsDeclared());

        }
    }
    //////////////////////////////////// CÁLCULOS //////////////////////////////////////////////////////////////////
    @Override
    public void totalTons(Declaration declaration) {
        double totalTons= 0.0;
        for(DeclarationItem item : declaration.getItens()){
            item.setDeclaration(declaration);

            validateTons(item);

            totalTons += item.getTonsDeclared();
        }
        declaration.setMaterialTotal(totalTons);
    }

    @Override
    public void totalCompensation(Declaration declaration) {
        double  totalCompens = 0.0;
        for(DeclarationItem item : declaration.getItens()){
            item.setDeclaration(declaration);

            validateMaterial(item);

            double percentCompens = item.getMaterial().getCompensationOfPercentage();
            double compens = item.getTonsDeclared() * (percentCompens / 100);
            item.setTonsCompensation(compens);

            totalCompens += compens;
        }
        declaration.setCompensationTotal(totalCompens);
    }

}
