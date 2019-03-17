package api.iti0208.controller;

import api.iti0208.data.entity.Post;
import api.iti0208.data.output.PostResponse;
import api.iti0208.data.input.PostPatchInput;
import api.iti0208.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static api.iti0208.security.SecurityConstants.*;

// PS! PostResponse holds the response and the amount of pages!

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("api/posts")
    public PostResponse getPosts(@RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "15") int size,
                                 @RequestParam(value = "topic", defaultValue = "all") String topic) {
        return postService.getPosts(page, size, topic);
    }

    @GetMapping("api/posts/{id}")
    public Post getPostItemById(@PathVariable Long id) {
        return postService.getPostItemById(id);
    }

    @GetMapping("api/posts/find")
    public PostResponse findPosts(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "15") int size,
                                  @RequestParam(value = "searchTerm", defaultValue = "") String searchTerm) {
        return postService.findPosts(page, size, searchTerm);
    }

    @PostMapping("api/add/post")
    public Post savePost(@RequestBody @Valid Post item,
                         @RequestHeader(value = HEADER_STRING) String header) {
        return postService.savePost(item, header);
    }

    @DeleteMapping("api/delete/post/{id}")
    @PreAuthorize("@postService.findUsernameOfPoster(#id) == authentication.name || hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        postService.deleteById(id);
    }

    @PatchMapping("api/edit/post/{id}")
    @PreAuthorize("@postService.findUsernameOfPoster(#id) == authentication.name || hasAuthority('ROLE_ADMIN')")
    public Post patchPost(@RequestBody @Valid PostPatchInput obj, @PathVariable Long id) {
        return postService.patchPost(obj, id);
    }

}
