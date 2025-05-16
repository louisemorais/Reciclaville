package br.senai.lab364.futurodev.reciclaville.dtos.DeclarationsDTO;

import br.senai.lab364.futurodev.reciclaville.dtos.DeclarationItemDTO.RequestDeclarationItemDTO;
import br.senai.lab364.futurodev.reciclaville.models.Client;
import java.time.LocalDate;
import java.util.List;

public record RequestDeclarationDTO(Client client,
                                    LocalDate startDate,
                                    LocalDate endDate,
                                    List<RequestDeclarationItemDTO> itens) {
}
