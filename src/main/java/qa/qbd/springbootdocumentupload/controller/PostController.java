package qa.qbd.springbootdocumentupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.feignclient.PostServiceProxy;
import qa.qbd.springbootdocumentupload.service.DocumentService;

@RestController
public class PostController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    PostServiceProxy postServiceProxy;

    @RequestMapping("/posts/{id}")
    public void addPostToDocument(@PathVariable long id){
        Post post = postServiceProxy.findPostById(id);
        System.out.println("post title: "+post.getTitle());

    }
}
