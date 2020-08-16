package qa.qbd.springbootdocumentupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qa.qbd.springbootdocumentupload.service.PostService;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts/{postId}/{userId}/{docId}")
    public void getPostAndAddToDocument(@PathVariable long postId,@PathVariable int userId,@PathVariable long docId){
        postService.getPostAndAddToDocument(postId,userId,docId);
    }

}
