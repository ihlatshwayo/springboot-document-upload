package qa.qbd.springbootdocumentupload.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private long  userId;

    private String email;

    private String body;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
