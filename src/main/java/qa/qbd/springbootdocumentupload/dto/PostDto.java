package qa.qbd.springbootdocumentupload.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Getter
public class PostDto implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private long userId;

    private String title;

    private String body;
}
