package com.fatec.ordemservico.ordemservico;

import com.fatec.ordemservico.ordemservico.dto.ResponseErrorDTO;
import com.fatec.ordemservico.ordemservico.dto.ResponseErrorValidationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class Handler {

    @Autowired
    private MessageSource messageSource;

    private final static String PREFIX_MESSAGE = "O campo %s %s";

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<ResponseErrorValidationDTO>> handlingException(BindException exception) {
        final var fieldsError = exception.getBindingResult().getFieldErrors();

        return ResponseEntity.status(BAD_REQUEST)
                .body(
                        fieldsError.stream().map(fieldError -> {
                            var message = this.messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                            log.error("Error {}", message);
                            return ResponseErrorValidationDTO.builder()
                                    .code(400)
                                    .message(String.format(PREFIX_MESSAGE, fieldError.getField(), message))
                                    .fieldError(fieldError.getField())
                                    .build();
                        }).collect(Collectors.toList()));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ResponseErrorDTO> handlingResponseStatusException(ResponseStatusException exception) {
        log.error("Error {}", exception);
        return ResponseEntity.status(exception.getStatus())
                .body(ResponseErrorDTO.builder()
                        .code(exception.getStatus().value())
                        .message(exception.getReason())
                        .build());
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErrorDTO> handlingExceptionGlobal(Exception exception) {
        log.error("Error {}", exception.getMessage());
        return ResponseEntity.status(500)
                .body(ResponseErrorDTO.builder()
                        .code(500)
                        .message(exception.getMessage())
                        .build());
    }
}
