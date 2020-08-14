package qa.qbd.springbootdocumentupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qa.qbd.springbootdocumentupload.dao.DocumentRepository;
import qa.qbd.springbootdocumentupload.entity.Document;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.feignclient.PostServiceProxy;
import qa.qbd.springbootdocumentupload.service.DocumentService;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    PostServiceProxy postServiceProxy;

    @GetMapping("/posts/{id}/{userId}/{docId}")
    public void getPostAndAddToDocument(@PathVariable long id,@PathVariable int userId,@PathVariable long docId){
        Post post = postServiceProxy.findPostById(id);
        System.out.println("post title: "+post.getTitle());
        post.setUserId(userId);
        Optional<Document> userDocument = documentRepository.findDocumentByIdAndUserId(docId,userId);
        userDocument.get().setPost(post);
        documentRepository.save(userDocument.get());

    }
}
