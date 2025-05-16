package br.senai.lab364.futurodev.reciclaville.errors.notFounds;

public abstract class NotFoundException extends RuntimeException{
    NotFoundException(String message){
        super(message);
    }
}
