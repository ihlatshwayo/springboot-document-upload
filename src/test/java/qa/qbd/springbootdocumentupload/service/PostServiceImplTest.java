package qa.qbd.springbootdocumentupload.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import qa.qbd.springbootdocumentupload.exceptions.PostNotFoundException;

public class PostServiceImplTest {

    @Autowired
    PostService postService;

    @ExceptionHandler(PostNotFoundException.class)
    public void getPostByIdFromAIP() throws Exception {

        long postId = 1190;

        postService.getPostByIdFromAIP(postId);

    }

    @Test
    public void  getValidPostAndAddToValidDocument() throws Exception {

        long postId = 1;
        long userId = 22;
        long docId = 1;

        postService.getPostAndAddToDocument(postId, userId, docId);





    }

    @Test
    public void  getInvalidPostAndAddToValidDocument(){

        long postId = 1;
        long userId = 22;
        long docId = 1;


    }

    @Test
    public void  getValidDocumentPost(){

        long postId = 1;
        long userId = 22;
        long docId = 1;

    }

    @Test
    public void  getInvalidDocumentPost(){
        long postId = 1;
        long userId = 22;
        long docId = 1;

    }



}
