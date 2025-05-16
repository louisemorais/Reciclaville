package br.senai.lab364.futurodev.reciclaville.errors.notFounds;

public class DeclarationNotFoundException extends NotFoundException {
    public DeclarationNotFoundException(Long id) {
        super("Declaration not found with id: "+ id);
    }
}
