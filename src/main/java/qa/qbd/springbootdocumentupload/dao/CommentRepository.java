package qa.qbd.springbootdocumentupload.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qa.qbd.springbootdocumentupload.entity.*;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {



    List<Comment> findCommentsByPostId(long postId);

}
