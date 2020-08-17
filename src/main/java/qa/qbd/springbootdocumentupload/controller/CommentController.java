package qa.qbd.springbootdocumentupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qa.qbd.springbootdocumentupload.dao.PostRepository;
import qa.qbd.springbootdocumentupload.entity.Comment;
import qa.qbd.springbootdocumentupload.feignclient.FeignDocumentClient;
import qa.qbd.springbootdocumentupload.service.CommentService;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    FeignDocumentClient feignDocumentClient;

    @Autowired
    CommentService commentService;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/getCommentAndAddToPost/{postId},{userId}")
    public void getCommentAndAddToPost(@PathVariable long postId, long userId){
        commentService.getCommentAndAddToPost(postId, userId);
    }

        @GetMapping("/getPostComments/{postId}")
        public List<Comment> getPostComments(@PathVariable long postId){
        return commentService.getPostComment(postId);
        }






}
