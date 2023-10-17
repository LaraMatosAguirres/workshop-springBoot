package com.educandoweb.course2.resources.exceptions;

import com.educandoweb.course2.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice // -> indica que a classe é um controlador de exceções global, lida com todo tipo de exceção
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // -> indica que o método lida com uma excessão personalizada específica
    public ResponseEntity<StandardError> resouceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND; // -> indica o número 404 na resposta front/postman
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); // -> encapsula as informações do erro em uma classe personaliza
        return ResponseEntity.status(status).body(err);
        // Retorna uma instância de ResponseEntity que contém o objeto StandardError como corpo da resposta e o status HTTP definido anteriormente. Isso enviará uma resposta HTTP com o código de status "Not Found" e as informações de erro apropriadas.
    }
}
