package br.senai.lab364.futurodev.reciclaville.errors.badRequests;

public class MaterialBadRequestException extends BadRequestException {
    public MaterialBadRequestException(String attribute) {
        super("Material",attribute);
    }
    public MaterialBadRequestException(String attribute,Double compensationOfPercentage) {
        super("Material", attribute +" (valor informado: "
                + compensationOfPercentage + ")");
    }
}
