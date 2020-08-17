package qa.qbd.springbootdocumentupload.exceptions;

public class DocumentNotFoundException extends RuntimeException{

    public DocumentNotFoundException(String errorMessage) {
        super(errorMessage);

    }

    public DocumentNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);

    }

}
