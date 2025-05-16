package br.senai.lab364.futurodev.reciclaville.errors.notFounds;

public class MaterialNotFoundException extends NotFoundException{
    public MaterialNotFoundException(Long id) {
        super("Material not found with id: "+ id);
    }
}
