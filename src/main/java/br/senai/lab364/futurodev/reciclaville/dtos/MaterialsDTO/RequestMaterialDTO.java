package br.senai.lab364.futurodev.reciclaville.dtos.MaterialsDTO;

import jakarta.persistence.Column;

public record RequestMaterialDTO(String name,
                                 double compensationOfPercentage){
}
