package qa.qbd.springbootdocumentupload.service;

import org.springframework.stereotype.Service;
import qa.qbd.springbootdocumentupload.entity.Document;
import qa.qbd.springbootdocumentupload.entity.Post;

import java.util.List;


public interface PostService {

    void getPostAndAddToDocument(long postId, int userId, long docId);

    List<Post> getUserPosts(int userId);

}
