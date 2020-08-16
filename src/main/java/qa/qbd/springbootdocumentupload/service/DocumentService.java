package qa.qbd.springbootdocumentupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import qa.qbd.springbootdocumentupload.entity.Comment;
import qa.qbd.springbootdocumentupload.entity.Document;
import qa.qbd.springbootdocumentupload.entity.Post;

import java.io.IOException;
import java.util.List;


public interface DocumentService {

    Object addDocument(MultipartFile multipartFile, int userId) throws IOException;

    List<Document> getUserDocuments(int userId);

    String deleteDocument(long documentId);




}
