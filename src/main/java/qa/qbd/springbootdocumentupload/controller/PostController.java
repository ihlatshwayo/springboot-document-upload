package qa.qbd.springbootdocumentupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qa.qbd.springbootdocumentupload.dto.PostDto;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.exceptions.DocumentNotFoundException;
import qa.qbd.springbootdocumentupload.exceptions.PostNotFoundException;
import qa.qbd.springbootdocumentupload.service.PostService;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts/{postId}/{userId}/{docId}")

    public void getPostAndAddToDocument(@PathVariable long postId,@PathVariable int userId,@PathVariable long docId)throws PostNotFoundException, DocumentNotFoundException, Exception{
        postService.getPostAndAddToDocument(postId,userId,docId) ;
    }
    @GetMapping("/get-dcoument-post/{docId}")
    public PostDto getDocumentPost(@PathVariable long docId) throws DocumentNotFoundException, Exception {
        return postService.getDocumentPost(docId);
    }

    @GetMapping("/posts/{postId}")
    @Retryable(maxAttempts = 5)
    Post findPostById(@PathVariable long postId) throws PostNotFoundException, Exception {
         return postService.getPostByIdFromAIP(postId);
    }

   /* @Recover
    public String getPostByIdFallback(Exception e){
        return "Failed to connect to API, to retrieve Post ID";
    }*/

}
