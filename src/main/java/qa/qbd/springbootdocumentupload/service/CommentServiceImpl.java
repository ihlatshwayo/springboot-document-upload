package qa.qbd.springbootdocumentupload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qa.qbd.springbootdocumentupload.dao.CommentRepository;
import qa.qbd.springbootdocumentupload.dao.PostRepository;
import qa.qbd.springbootdocumentupload.entity.Comment;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.feignclient.FeignDocumentClient;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    FeignDocumentClient feignDocumentClient;
    @Override
    public void getCommentAndAddToPost(long postId, long userId) {
        List<Comment>  comments =  feignDocumentClient.getPostComments(postId);

        Post post = postRepository.findPostByUserId(userId);

        if(post  != null ){

            for (Comment comment : comments) {
              //  comment.setPost(post);
                comment.setUserId(userId);

                post.getComments().add(comment);
            }


            postRepository.save(post);
        }

    }

    @Override
    public List<Comment> getPostComment(long postId) {
        return commentRepository.findCommentsByPostId(postId);
    }
}
