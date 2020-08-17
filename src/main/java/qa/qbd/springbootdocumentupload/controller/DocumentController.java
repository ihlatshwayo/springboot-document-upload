package qa.qbd.springbootdocumentupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import qa.qbd.springbootdocumentupload.dto.DocumentDto;
import qa.qbd.springbootdocumentupload.entity.Document;
import qa.qbd.springbootdocumentupload.exceptions.DocumentNotFoundException;
import qa.qbd.springbootdocumentupload.exceptions.IncorrectFileTypeException;
import qa.qbd.springbootdocumentupload.feignclient.FeignDocumentClient;
import qa.qbd.springbootdocumentupload.service.DocumentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    FeignDocumentClient feignDocumentClient;



    @PostMapping("/add_document/{userId}")
    public Object addDocument(MultipartFile multipartFile, @PathVariable int userId) throws IOException, IncorrectFileTypeException, Exception {

        return documentService.addDocument(multipartFile, userId);
    }

    @GetMapping("/get_user_document/{userId}")
    public List<DocumentDto> getUserDocumentById(@PathVariable int userId) throws DocumentNotFoundException, Exception{

        List<DocumentDto> documentDtos = new ArrayList<>();
        DocumentDto documentDto = new DocumentDto();

        List<Document> userDocuments = documentService.getUserDocuments(userId);

        for (Document document:userDocuments) {
            documentDto.setDoc(document.getDoc());
            documentDto.setFileName(document.getFileName());
            documentDto.setId(document.getId());
            documentDto.setUserId(document.getUserId());

            documentDtos.add(documentDto);

        }
        return documentDtos;
    }

    @DeleteMapping("/remove_document/{documentId}")
    public String deleteDocument(@PathVariable int documentId) throws  Exception{

        return documentService.deleteDocument(documentId);
    }

}
