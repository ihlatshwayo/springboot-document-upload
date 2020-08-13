package qa.qbd.springbootdocumentupload.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qa.qbd.springbootdocumentupload.entity.*;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    public Comment findCommentById(int userId);
}
