package qa.qbd.springbootdocumentupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qa.qbd.springbootdocumentupload.dao.PostRepository;
import qa.qbd.springbootdocumentupload.entity.Comment;
import qa.qbd.springbootdocumentupload.feignclient.PostServiceProxy;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    PostServiceProxy postServiceProxy;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts/{postId}/comments/{userId}")
    public void getCommentAndAddToDocumentPost(@PathVariable long postId, @PathVariable int userId){



    }
}
