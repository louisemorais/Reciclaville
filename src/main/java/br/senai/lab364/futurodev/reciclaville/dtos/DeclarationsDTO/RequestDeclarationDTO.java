package br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO;

import br.senai.lab364.futurodev.reciclaville.models.Client;
import jakarta.persistence.Column;

import java.util.Date;

public record RequestDeclarationDTO(Client client,
                                    Date dateOfDeclaration,
                                    Date startDate,
                                    Date endDate,
                                    double materialTotal,
                                    double compensationTotal) {
}
