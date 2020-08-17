package qa.qbd.springbootdocumentupload.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import qa.qbd.springbootdocumentupload.dao.CommentRepository;
import qa.qbd.springbootdocumentupload.dao.DocumentRepository;
import qa.qbd.springbootdocumentupload.dao.PostRepository;
import qa.qbd.springbootdocumentupload.entity.*;
import qa.qbd.springbootdocumentupload.exceptions.DocumentNotFoundException;
import qa.qbd.springbootdocumentupload.exceptions.IncorrectFileTypeException;
import qa.qbd.springbootdocumentupload.exceptions.PostNotFoundException;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentServiceImpl  implements DocumentService {


    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private DocumentRepository documentRepository;


    @Override
    public Object addDocument(MultipartFile multipartFile, long userId) throws IOException, IncorrectFileTypeException, Exception {

        try {

            if (!multipartFile.getContentType().equalsIgnoreCase("application/pdf")){
                throw new IncorrectFileTypeException("Only PDF documents supported");
            }

            Document document = new Document();

            document.setDoc(multipartFile.getBytes());
            document.setFileName(multipartFile.getOriginalFilename());
            document.setUserId(userId);

            documentRepository.save(document);



        }catch(Exception e){
            throw e;
        }

        return "Document successfully uploaded.";
    }

    @Override
    public List<Document> getUserDocuments(long userId) throws DocumentNotFoundException, Exception{

        try {

            List<Document> documents = documentRepository.findByUserId(userId);

            if (documents.isEmpty() ){
                throw new DocumentNotFoundException("Documents not found for user " + userId);
            }

            return documents;

        }catch(Exception e){
            throw e;
        }

    }

    @Override
    public String deleteDocument(long documentId) throws Exception{

        try {

            documentRepository.deleteById(documentId);

        }catch(Exception e){
            throw e;
        }

        return "Successfully deleted the document";
    }

}


