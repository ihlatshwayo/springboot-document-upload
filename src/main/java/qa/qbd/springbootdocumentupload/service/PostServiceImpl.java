package qa.qbd.springbootdocumentupload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import qa.qbd.springbootdocumentupload.dao.DocumentRepository;
import qa.qbd.springbootdocumentupload.dto.PostDto;
import qa.qbd.springbootdocumentupload.entity.Document;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.exceptions.DocumentNotFoundException;
import qa.qbd.springbootdocumentupload.exceptions.PostNotFoundException;
import qa.qbd.springbootdocumentupload.feignclient.FeignDocumentClient;

import java.util.Optional;

@Service
public class PostServiceImpl  implements PostService{

    @Autowired
    FeignDocumentClient feignDocumentClient;

    @Autowired
    private DocumentRepository documentRepository;


    public void getPostAndAddToDocument(long postId, long userId, long docId) throws PostNotFoundException, DocumentNotFoundException, Exception {

        try {


            Post post = getPostByIdFromAIP(postId);

            post.setUserId(userId);
            Optional<Document> userDocument = documentRepository.findDocumentByIdAndUserId(docId,userId);

            if (!userDocument.isPresent() ){
                throw new DocumentNotFoundException("Document not found") ;
            }

            userDocument.ifPresent (document -> document.setPost(post));

            documentRepository.save(userDocument.get());

        }catch(PostNotFoundException e){
            throw e;
        }catch(Exception e){
            throw e;
        }


    }

    public Post getPostByIdFromAIP(long postId) throws PostNotFoundException, Exception {

        Post post = null;

        try {

            post = feignDocumentClient.findPostById(postId);

            if (post == null){
                throw new PostNotFoundException("Post not Found");
            }

        }catch(Exception e){
            throw e;
        }

        return post;
    }

    @Override
    public PostDto getDocumentPost(long documentId) throws DocumentNotFoundException, Exception{

        try {

            Optional<Document> document = documentRepository.findById(documentId);

            if (!document.isPresent() ){
                throw new DocumentNotFoundException("Document not found") ;
            }

            PostDto postDto = new PostDto();
            if (document.isPresent()) {

                postDto.setBody(document.get().getPost().getBody());
                postDto.setTitle(document.get().getPost().getTitle());
                postDto.setId(document.get().getPost().getId());
                postDto.setUserId(document.get().getPost().getUserId());

                return postDto;
            }

        }catch(Exception e){
            throw e;
        }

        return null;

    }


}



