package qa.qbd.springbootdocumentupload.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import qa.qbd.springbootdocumentupload.entity.Comment;
import qa.qbd.springbootdocumentupload.entity.Post;

import java.util.List;


@FeignClient(name="jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface PostServiceProxy {
    @GetMapping("/posts/{postId}")
    public Post findPostById(@PathVariable Long postId);


    @GetMapping("/posts/{postId}/{userId}/{docId}")
    public void getPostAndAddToDocument(@PathVariable long postId,@PathVariable int userId,@PathVariable long docId);

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getCommentAndAddToDocumentPost(@PathVariable long postId);


}
