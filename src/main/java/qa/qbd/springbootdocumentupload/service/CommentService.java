package qa.qbd.springbootdocumentupload.service;

import org.springframework.stereotype.Service;


public interface CommentService {

    void getCommentAndAddToDocumentPost(long postId, int userId);
}
