package br.senai.lab364.futurodev.reciclaville.errors.badRequests;

public abstract class BadRequestException extends RuntimeException{
    BadRequestException(String message){
        super(message);
    }
}
