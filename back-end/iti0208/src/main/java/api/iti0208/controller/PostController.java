package api.iti0208.controller;

import api.iti0208.entity.Post;
import api.iti0208.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final PostRepository dao;

    @Autowired
    public PostController(PostRepository dao) {
        this.dao = dao;
    }

    @GetMapping("api/posts")
    @CrossOrigin(origins = "http://localhost:8080")
    public Iterable<Post> getTodoItems() {
        return dao.findAll();
    }

    @PostMapping("api/addpost")
    public Post save(@RequestBody Post item) {
        return dao.save(item);
    }

    @DeleteMapping("api/items/{id}")
    public void delete(@PathVariable Long id) {
        dao.deleteById(id);
    }
}