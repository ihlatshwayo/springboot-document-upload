package qa.qbd.springbootdocumentupload.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class Post {

    @Id
    @GeneratedValue
    private long id;

    private int userId;

    private String title;

    private String body;

    @OneToMany( cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Set<Comment> comments;



}
