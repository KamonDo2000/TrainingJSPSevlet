package fa.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fa.training.model.Comment;
import fa.training.model.Post;
import fa.training.service.CommentService;
import fa.training.service.PostService;

@Controller
public class HomeController {
	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	/**
	 * function handle /HomePage
	 * 
	 * @return Home
	 */
	@GetMapping(value = { "/", "/index" })
	public String homePage(Model home, HttpSession session) {
		List<Post> listPost = postService.getAllPost();
		home.addAttribute("listPost", listPost);
		List<Comment> listComments = commentService.getAllCommentsApproved();
		home.addAttribute("listComments", listComments);
		return "index";
	}
}
