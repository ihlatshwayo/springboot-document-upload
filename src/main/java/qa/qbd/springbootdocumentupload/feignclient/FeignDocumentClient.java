package qa.qbd.springbootdocumentupload.feignclient;

import com.sun.media.sound.InvalidDataException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import qa.qbd.springbootdocumentupload.dto.PostDto;
import qa.qbd.springbootdocumentupload.entity.Comment;
import qa.qbd.springbootdocumentupload.entity.Post;
import qa.qbd.springbootdocumentupload.exceptions.PostNotFoundException;
import qa.qbd.springbootdocumentupload.fallback.PostNotFoundFallBack;

import java.util.List;


@FeignClient(name="jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface FeignDocumentClient {
    @GetMapping("/posts/{postId}")
    Post findPostById(@PathVariable long postId) throws PostNotFoundException;


    @GetMapping("/posts/{postId}/{userId}/{docId}")
    void getPostAndAddToDocument(@PathVariable long postId,@PathVariable int userId,@PathVariable long docId);

    @GetMapping("/posts/{postId}/comments")
     List<Comment> getCommentAndAddToDocumentPost(@PathVariable long postId);

    @GetMapping("/{docId}")
     void getDocumentPost(@PathVariable long docId) throws PostNotFoundException;

    @GetMapping("/getCommentAndAddToPost/{postId},{userId}")
    void getCommentAndAddToPost(@PathVariable long postId, long userId) throws IllegalAccessException, InvalidDataException;

    @GetMapping("/posts/{postId}/comments")
    List<Comment> getPostComments(@PathVariable long postId);

}
