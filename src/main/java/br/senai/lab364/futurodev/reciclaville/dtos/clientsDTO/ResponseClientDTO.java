package br.senai.lab364.futurodev.reciclaville.dtos.clientsDTO;

import lombok.Data;

@Data
public class ResponseClientDTO {
    private Long id;
    private String name;
    private  String cnpj;
    private String economicActivity;
    private  String accontable;
}
