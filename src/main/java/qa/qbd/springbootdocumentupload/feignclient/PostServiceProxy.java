package qa.qbd.springbootdocumentupload.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import qa.qbd.springbootdocumentupload.entity.Post;


@FeignClient(name="jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface PostServiceProxy {
    @RequestMapping("/posts/{id}")
    public Post findPostById(@PathVariable(value="id") Long id);

    @RequestMapping("/posts/{id}/comments")
    public void addCommentToDocument(@PathVariable long id);

    }
}
