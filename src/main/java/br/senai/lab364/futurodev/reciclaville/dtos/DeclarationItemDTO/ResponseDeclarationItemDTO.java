package br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO;

import br.senai.lab364.futurodev.reciclaville.models.Material;
import lombok.Builder;

@Builder
public record ResponseDeclarationItemDTO(Long id,
                                         Long declarationId,
                                         Material material,
                                         Double percentage,
                                         double tonsDeclared,
                                         double tonsCompensation) {
}