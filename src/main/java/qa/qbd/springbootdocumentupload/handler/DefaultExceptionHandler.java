package qa.qbd.springbootdocumentupload.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import qa.qbd.springbootdocumentupload.dto.ErrorDTO;
import qa.qbd.springbootdocumentupload.exceptions.DocumentNotFoundException;
import qa.qbd.springbootdocumentupload.exceptions.IncorrectFileTypeException;
import qa.qbd.springbootdocumentupload.exceptions.PostNotFoundException;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlePostNotFoundException(PostNotFoundException ex) {

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorDTO.setErrorMessage(ex.getMessage());

        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectFileTypeException.class)
    public ResponseEntity<ErrorDTO> handleIncorrectFileTypeException(IncorrectFileTypeException ex) {

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
        errorDTO.setErrorMessage(ex.getMessage());

        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDocumentNotFoundException(DocumentNotFoundException ex) {

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorDTO.setErrorMessage(ex.getMessage());

        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }



}
