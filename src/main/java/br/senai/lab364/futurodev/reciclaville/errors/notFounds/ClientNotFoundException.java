package br.senai.lab364.futurodev.reciclaville.errors.notFounds;

public class ClientNotFoundException extends NotFoundException {
    public ClientNotFoundException(Long id) {
        super("Client not found with id: "+ id);
    }
}
