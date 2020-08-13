package qa.qbd.springbootdocumentupload.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private int post_id;

    private int  userId;

    private String email;

    private String body;

    private String name;

}
