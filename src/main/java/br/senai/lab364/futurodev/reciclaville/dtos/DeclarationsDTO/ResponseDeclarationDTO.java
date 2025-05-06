package br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO;

import br.senai.lab364.futurodev.reciclaville.models.Client;

import java.util.Date;

public record ResponseDeclarationDTO(Long id,
                                     Client client,
                                     Date dateOfDeclaration,
                                     Date startDate,
                                     Date endDate,
                                     double materialTotal,
                                     double compensationTotal) {
}
