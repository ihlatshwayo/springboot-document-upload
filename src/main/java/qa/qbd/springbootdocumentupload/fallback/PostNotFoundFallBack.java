package qa.qbd.springbootdocumentupload.fallback;
import java.util.Collections;
import java.util.List;

import com.sun.media.sound.InvalidDataException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import qa.qbd.springbootdocumentupload.dto.ErrorDTO;
import qa.qbd.springbootdocumentupload.entity.Comment;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.exceptions.DocumentNotFoundException;
import qa.qbd.springbootdocumentupload.exceptions.PostNotFoundException;
import qa.qbd.springbootdocumentupload.feignclient.FeignDocumentClient;


public class PostNotFoundFallBack implements FeignDocumentClient {

    @Override
    public Post findPostById(long postId) throws PostNotFoundException {
        throw new PostNotFoundException("Post not found");
    }

    @Override
    public void getPostAndAddToDocument(long postId, int userId, long docId) {
        throw new DocumentNotFoundException("Document not found");
    }

    @Override
    public List<Comment> getCommentAndAddToDocumentPost(long postId) {
        return Collections.emptyList();
    }

    @Override
    public void getDocumentPost(long docId) throws PostNotFoundException {
        throw new PostNotFoundException("Post not found");
    }

    @Override
    public void getCommentAndAddToPost(long postId, long userId) throws  InvalidDataException {
        throw new InvalidDataException("Error retrieving post or saving to database");
    }

    @Override
    public List<Comment> getPostComments(long postId) {
        return Collections.emptyList();
    }
}
