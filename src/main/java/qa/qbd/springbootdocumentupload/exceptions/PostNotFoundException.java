package qa.qbd.springbootdocumentupload.exceptions;

public class PostNotFoundException extends Exception{

    public PostNotFoundException(String errorMessage) {
        super(errorMessage);

    }

    public PostNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);

    }

}
