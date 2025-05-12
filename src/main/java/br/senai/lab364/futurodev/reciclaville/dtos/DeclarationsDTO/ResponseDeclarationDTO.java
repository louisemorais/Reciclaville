package br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO.ResponseDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.models.Client;

import java.time.LocalDate;
import java.util.List;

public record ResponseDeclarationDTO(Long id,
                                     Client client,
                                     LocalDate dateOfDeclaration,
                                     LocalDate startDate,
                                     LocalDate endDate,
                                     double materialTotal,
                                     double compensationTotal,
                                     List<ResponseDeclarationItemDTO> itens) {
}
