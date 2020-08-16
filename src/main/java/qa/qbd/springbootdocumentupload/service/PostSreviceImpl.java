package qa.qbd.springbootdocumentupload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qa.qbd.springbootdocumentupload.dao.DocumentRepository;
import qa.qbd.springbootdocumentupload.entity.Document;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.feignclient.PostServiceProxy;

import java.util.Optional;

@Service
public class PostSreviceImpl  implements PostService{

    @Autowired
    PostServiceProxy postServiceProxy;

    @Autowired
    private DocumentRepository documentRepository;


    public void getPostAndAddToDocument(long postId, int userId, long docId){
        Post post = postServiceProxy.findPostById(postId);


        post.setUserId(userId);
        Optional<Document> userDocument = documentRepository.findDocumentByIdAndUserId(docId,userId);

        userDocument.ifPresent(document -> document.setPost(post));

        documentRepository.save(userDocument.get());

    }
}
