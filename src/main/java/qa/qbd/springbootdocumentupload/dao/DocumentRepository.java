package qa.qbd.springbootdocumentupload.dao;

import org.springframework.stereotype.Repository;
import qa.qbd.springbootdocumentupload.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository< Document, Long> {

    List<Document> findByUserId(int userId);
    Optional<Document>  findDocumentByIdAndUserId(long docId, int userId);
}
