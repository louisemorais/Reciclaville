package br.senai.lab364.futurodev.reciclaville.dtos.declarationDTOs;

import br.senai.lab364.futurodev.reciclaville.dtos.declarationItemDTOs.RequestDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.models.Client;
import java.time.LocalDate;
import java.util.List;

public record RequestDeclarationDTO(Client client,
                                    LocalDate startDate,
                                    LocalDate endDate,
                                    List<RequestDeclarationItemDTO> itens) {
}
