package qa.qbd.springbootdocumentupload.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import qa.qbd.springbootdocumentupload.dao.CommentRepository;
import qa.qbd.springbootdocumentupload.dao.DocumentRepository;
import qa.qbd.springbootdocumentupload.dao.PostRepository;
import qa.qbd.springbootdocumentupload.entity.*;
import qa.qbd.springbootdocumentupload.feignclient.PostServiceProxy;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl  implements DocumentService {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private DocumentRepository documentRepository;


    @Override
    public Object addDocument(MultipartFile multipartFile, int userId) throws IOException {

        Document document = new Document();

        document.setDoc(multipartFile.getBytes());
        document.setFileName(multipartFile.getOriginalFilename());
        document.setUserId(userId);

        ;
        documentRepository.save(document);

        return null;
    }

    @Override
    public List<Document> getUserDocuments(int userId) {

        return documentRepository.findByUserId(userId);
    }

    @Override
    public String deleteDocument(long documentId) {
        documentRepository.deleteById(documentId);
        return "Successfully deleted the document";
    }

}


