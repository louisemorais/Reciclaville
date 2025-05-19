package br.senai.lab364.futurodev.reciclaville.dtos.declarationItemDTOs;

import br.senai.lab364.futurodev.reciclaville.models.Material;

public record RequestDeclarationItemDTO(Material material,
                                        double tonsDeclared) {
}