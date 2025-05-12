package br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO;

import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import br.senai.lab364.futurodev.reciclaville.models.DeclarationItem;
import br.senai.lab364.futurodev.reciclaville.models.Material;
import lombok.Builder;

@Builder
public record ResponseDeclarationItemDTO(Long id,
                                         Declaration declarationId,
                                         Material material,
                                         double percentage,
                                         double tonsDeclared,
                                         double tonsCompensation) {
}