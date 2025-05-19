package br.senai.lab364.futurodev.reciclaville.errors.badRequests;

public class DeclarationBadRequestException extends BadRequestException {
    public DeclarationBadRequestException(String attribute) {
        super("Declaration", attribute);
    }
    public DeclarationBadRequestException(Double tonsDeclared) {
        super("DeclarationItem", "(value reported: "
                + tonsDeclared + ")");
    }
}
