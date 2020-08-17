package qa.qbd.springbootdocumentupload.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
public class Post {

    @Id
    @GeneratedValue
    private long id;

    private long userId;

    private String title;

    private String body;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL ,
    orphanRemoval = true,
    fetch = FetchType.LAZY)
    //@JoinColumn(name = "post_id")
    private List<Comment> comments;


 /*   @OneToMany(mappedBy = "post")
    private Collection<Comment> comment;

    public Collection<Comment> getComment() {
        return comment;
    }

    public void setComment(Collection<Comment> comment) {
        this.comment = comment;
    }*/
}
