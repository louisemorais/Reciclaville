package br.senai.lab364.futurodev.reciclaville.services.Declaration;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.RequestDeclarationDTO;
import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO.ResponseDeclarationDTO;
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
    private final MaterialRepository repositorymaterial;
    private final ClientRepository repositoryclient;
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

        clientsValidation(dto);
        datesValidation(dto, declaration);
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
    public void datesValidation(RequestDeclarationDTO dto, Declaration declaration) {
        declaration.setDateOfDeclaration(LocalDate.now());

        if(dto.startDate().isAfter(dto.endDate())||dto.endDate().isBefore(dto.startDate()))
            throw new DeclarationBadRequestException("Your date");
    }

    @Override
    public void clientsValidation(RequestDeclarationDTO dto) {
        Long idClient=dto.client().getId();
        if (idClient == null || !repositoryclient.existsById(idClient)) {
            throw new ClientNotFoundException(idClient);
        }
    }

    @Override
    public void materialValidation(DeclarationItem item) {
        Long materialId = item.getMaterial().getId();
        Material material = repositorymaterial.findById(materialId).orElseThrow(()
                ->  new MaterialNotFoundException(materialId));
        item.setMaterial(material);
    }

    @Override
    public void toneladasValidation(DeclarationItem item) {
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

            toneladasValidation(item);

            totalTons += item.getTonsDeclared();
        }
        declaration.setMaterialTotal(totalTons);
    }

    @Override
    public void totalCompensation(Declaration declaration) {
        double  totalCompens = 0.0;
        for(DeclarationItem item : declaration.getItens()){
            item.setDeclaration(declaration);

            materialValidation(item);

            double percentCompens = item.getMaterial().getCompensationOfPercentage();
            double compens = item.getTonsDeclared() * (percentCompens / 100);
            item.setTonsCompensation(compens);

            totalCompens += compens;
        }
        declaration.setCompensationTotal(totalCompens);
    }

}
