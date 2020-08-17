package qa.qbd.springbootdocumentupload.service;

import qa.qbd.springbootdocumentupload.dto.PostDto;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.exceptions.PostNotFoundException;

import java.util.List;


public interface PostService {

    void getPostAndAddToDocument(long postId, long userId, long docId) throws PostNotFoundException, Exception;

    PostDto getDocumentPost(long documentId) throws Exception;

    Post getPostByIdFromAIP(long postId) throws PostNotFoundException, Exception;

}
