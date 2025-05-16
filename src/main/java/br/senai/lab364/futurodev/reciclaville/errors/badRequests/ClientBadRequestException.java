package br.senai.lab364.futurodev.reciclaville.errors.badRequests;

public class ClientBadRequestException extends BadRequestException {
    public ClientBadRequestException(String attribute) {
        super("Client",attribute);
    }

    public ClientBadRequestException(String attribute, String value) {
        super("Client", attribute + " (valor informado: " + value + ")");
    }
}
