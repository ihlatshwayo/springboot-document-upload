package qa.qbd.springbootdocumentupload.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qa.qbd.springbootdocumentupload.entity.*;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostByUserId(long userId);

}
