package br.senai.lab364.futurodev.reciclaville.dtos.errors;

public record ResponseErrorDTO(
        String code,
        String message,
        String cause,
        String name) {
}
