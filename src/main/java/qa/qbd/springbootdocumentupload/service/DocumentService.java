package qa.qbd.springbootdocumentupload.service;

import org.springframework.web.multipart.MultipartFile;
import qa.qbd.springbootdocumentupload.entity.Document;

import java.io.IOException;
import java.util.List;


public interface DocumentService {

    Object addDocument(MultipartFile multipartFile, long userId) throws IOException, Exception;

    List<Document> getUserDocuments(long userId) throws Exception;

    String deleteDocument(long documentId) throws Exception;






}
