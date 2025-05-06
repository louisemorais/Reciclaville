package br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO;

import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import br.senai.lab364.futurodev.reciclaville.models.Material;


public record RequestDeclarationItemDTO(Declaration declaration,
                                        Material material,
                                        double percentage,
                                        double tonsDeclared,
                                        double tonsCompensation) {
}