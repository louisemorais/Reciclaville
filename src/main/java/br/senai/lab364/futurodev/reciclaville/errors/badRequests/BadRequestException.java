package br.senai.lab364.futurodev.reciclaville.errors.badRequests;

public abstract class BadRequestException extends RuntimeException{
    BadRequestException(String objName,String attribute){
        super("Required attribute for "+objName+".attribute "+attribute+" is incorrect or is not present");
    }
}
