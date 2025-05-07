package br.senai.lab364.futurodev.reciclaville.dtos.ClientsDTO;

import lombok.Data;

@Data
public class RequestClientDTO {
    private String name;
    private String cnpj;
    private String economicActivity;
    private  String accontable;
}
