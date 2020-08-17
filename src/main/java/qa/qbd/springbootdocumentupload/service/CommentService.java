package qa.qbd.springbootdocumentupload.service;

import org.springframework.web.bind.annotation.PathVariable;
import qa.qbd.springbootdocumentupload.entity.Comment;

import java.util.List;

public interface CommentService {

    void getCommentAndAddToPost(long postId, long userId);

    public List<Comment> getPostComment(long postId);

}
