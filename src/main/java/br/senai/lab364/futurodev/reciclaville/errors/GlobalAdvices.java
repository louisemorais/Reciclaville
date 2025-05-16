package br.senai.lab364.futurodev.reciclaville.errors;

import br.senai.lab364.futurodev.reciclaville.dtos.errors.ResponseErrorDTO;
import br.senai.lab364.futurodev.reciclaville.errors.badRequests.BadRequestException;
import br.senai.lab364.futurodev.reciclaville.errors.notFounds.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalAdvices{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErrorDTO> handle(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseErrorDTO("500", e.getMessage(),
                e.getCause()!= null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName())
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseErrorDTO> handle(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseErrorDTO(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getName()
        ));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseErrorDTO> handle(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDTO(
                "400",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getName()
        ));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseErrorDTO> handle(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDTO(
                "400",
                "Erro de leitura do corpo da requisição. Verifique o JSON enviado.",
                e.getCause() != null ? e.getCause().getMessage() : null,
                e.getClass().getName()
        ));
    }
}
