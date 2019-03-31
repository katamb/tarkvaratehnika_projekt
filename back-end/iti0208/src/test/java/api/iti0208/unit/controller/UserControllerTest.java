package api.iti0208.unit.controller;

import api.iti0208.controller.UserController;
import api.iti0208.data.entity.Post;
import api.iti0208.service.PostService;
import api.iti0208.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    // TODO

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    @MockBean
    private UserService userService;

    @Test
    public void testFindAllPosts() throws Exception {

    }

}
