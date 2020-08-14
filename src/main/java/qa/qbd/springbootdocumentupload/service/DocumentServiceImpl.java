package qa.qbd.springbootdocumentupload.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import qa.qbd.springbootdocumentupload.dao.CommentRepository;
import qa.qbd.springbootdocumentupload.dao.DocumentRepository;
import qa.qbd.springbootdocumentupload.dao.PostRepository;
import qa.qbd.springbootdocumentupload.entity.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl  implements DocumentService{

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Object addDocument(MultipartFile multipartFile, int userId) throws IOException {

        Document document = new Document();

        document.setDoc(multipartFile.getBytes());
        document.setFileName(multipartFile.getOriginalFilename());
        document.setUserId(userId);
        
        Post post = new Post();
        post.setBody("Given");
        document.setPost(post);
;       documentRepository.save(document);

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

    @Override
    public String addPost(Post post, int userId) {
        //design user document retrival
        //Optional<Document> document =  documentRepository.findByUserId(userId);

       // document.get().setPost(post);
        postRepository.save(post);
        return "post succesfully added to document";
    }

    @Override
    public String addComment(Comment comment, int userId) {
        commentRepository.save(comment);
        return "Comment succesfully added to document";
    }

    public  void createDocumentPost(){

        // response

      Optional<Document> document =  documentRepository.findById(1L) ;
       // post api and set post

        Post post = new Post();

        //post.setBody();

        document.get().setPost(post);

        //documentRepository.save(document);


    }
    public void createDocumentComment(){


    }
}
