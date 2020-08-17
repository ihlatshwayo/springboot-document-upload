package qa.qbd.springbootdocumentupload.exceptions;

public class IncorrectFileTypeException extends RuntimeException {

    public IncorrectFileTypeException(String errorMessage) {
        super(errorMessage);
    }
    public IncorrectFileTypeException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
