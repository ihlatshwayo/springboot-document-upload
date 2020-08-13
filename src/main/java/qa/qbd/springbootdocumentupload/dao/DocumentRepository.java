package qa.qbd.springbootdocumentupload.dao;

import org.springframework.stereotype.Repository;
import qa.qbd.springbootdocumentupload.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository< Document, Long> {

    List<Document> findByUserId(int userId);
}
