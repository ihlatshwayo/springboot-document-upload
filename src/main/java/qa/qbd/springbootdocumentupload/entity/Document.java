package qa.qbd.springbootdocumentupload.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Document {
    @Id
    @GeneratedValue
    private long id;
    private long userId;
    private String fileName;
    @Lob
    private byte[] doc;

    @OneToOne(targetEntity = Post.class,orphanRemoval = true, cascade = CascadeType.ALL)
    private Post post;
}
