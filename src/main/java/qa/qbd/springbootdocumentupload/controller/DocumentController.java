package qa.qbd.springbootdocumentupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import qa.qbd.springbootdocumentupload.entity.Document;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.feignclient.PostServiceProxy;
import qa.qbd.springbootdocumentupload.service.DocumentService;

import java.io.IOException;
import java.util.List;

@RestController

//@RequestMapping("/api/v1/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    PostServiceProxy postServiceProxy;



    @PostMapping("/add_document/{userId}")
    public Object addDocument(MultipartFile multipartFile, @PathVariable int userId) throws IOException {

        documentService.addDocument(multipartFile, userId);
        return "Successfully added s document";
    }

    @GetMapping("/get_user_document/{userId}")
    public List<Document> getUserDocumentById(@PathVariable int userId){
        return documentService.getUserDocuments(userId);
    }

    @DeleteMapping("/remove_document/{documentId}")
    public String deleteDocument(@PathVariable int documentId){

        return documentService.deleteDocument(documentId);
    }

}
