package qa.qbd.springbootdocumentupload.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;

@Setter
@Getter
public class DocumentDto implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private long userId;
    private String fileName;
    @Lob
    private byte[] doc;
}
