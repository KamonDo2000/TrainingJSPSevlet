package fa.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.model.Post;
import fa.training.service.CommentService;
import fa.training.service.PostService;

/**
 * This Class Post Controller Consist of many mapping process functions. Post:
 * ManagePost, CreatePost, deletePost, editPost.
 * 
 * @author VuPH7
 *
 */
@Controller
public class PostController {

	// declare PostService
	@Autowired
	private PostService postService;

	// declare CommentService
	@Autowired
	private CommentService commentService;

	/**
	 * function Get Mapping with direct: /CreatePostPage.
	 * 
	 * @return CreatePostPage page
	 */
	@GetMapping("/CreatePostPage")
	public String createPostPage() {
		return "CreatePostPage";
	}

	/**
	 * function Post Mapping with direct: /savePost. create new post
	 * 
	 * @param post
	 * @param theBindingResult
	 * @param session
	 * @return /ManagePostPage/1 page
	 */
	@PostMapping("/savePost")
	public String inserPost(@Valid @ModelAttribute("postForm") Post post, BindingResult theBindingResult,
			HttpSession session) {
		int userId = (int) session.getAttribute("userId");
		postService.insertPost(post, userId);

		return "redirect:/ManagePostPage/1";
	}

	/**
	 * function Get Mapping with direct: /ManagePostPage/{page_id}
	 * 
	 * @param post
	 * @param session
	 * @param page_id
	 * @return /ManagePostPage/{page_id} page
	 */
	@GetMapping("/ManagePostPage/{page_id}")
	public String managePostPage(Model post, HttpSession session, @PathVariable int page_id) {
		int userId = (int) session.getAttribute("userId");
		Long total = postService.countPostByUserId(userId);
		int pageSize = 15;
		int listPage = 0;
		if (total % pageSize > 0) {
			listPage = (int) (total / pageSize + 1);
		} else {
			listPage = (int) (total / pageSize);
		}
		List<Post> listPost = postService.getAllPostByUserIdPaging(userId, page_id, pageSize);
		post.addAttribute("listPost", listPost);
		post.addAttribute("page_id", page_id);
		post.addAttribute("totalPage", listPage);
		return "ManagePostPage";
	}

	/**
	 * function Get Mapping with direct: /ManagePostPage/{page_id}/delete
	 * 
	 * @param post_id
	 * @param session
	 * @return
	 */
	@GetMapping("/ManagePostPage/{page_id}/delete")
	public String deletePost(@RequestParam("postId") int post_id, HttpSession session) {
		boolean result = postService.deletePost(post_id);

		if (!result) {
			return "redirect:/ManagePostPage/1";
		}

		if (session.getAttribute("userId") != null) {
			session.setAttribute("totalComment",
					commentService.countAllCommentByUserId((int) session.getAttribute("userId")));
		}
		return "redirect:/ManagePostPage/1";
	}

	/**
	 * function Get Mapping with direct: /ManagePostPage/{page_id}/edit
	 * 
	 * @param post_id
	 * @param session
	 * @return
	 */
	@GetMapping("/ManagePostPage/{page_id}/edit")
	public String editPost(@RequestParam("postId") int post_id, HttpSession session) {
		session.setAttribute("postId", post_id);
		return "redirect:/EditPostPage";
	}

	/**
	 * function Get Mapping with direct: /EditPostPage
	 * 
	 * @param post
	 * @param session
	 * @return EditPostPage page
	 */
	@GetMapping("/EditPostPage")
	public String editPostPage(Model post, HttpSession session) {
		if (session.getAttribute("postId") != null) {
			int post_id = (int) session.getAttribute("postId");
			Post postEdited = postService.getPostByPostId(post_id);
			post.addAttribute("postEdited", postEdited);
			return "EditPostPage";
		}
		return "redirect:/ManagePostPage";
	}

	/**
	 * function Post Mapping with direct: /editPost
	 * 
	 * @param post
	 * @param theBindingResult
	 * @param session
	 * @return /ManagePostPage/1 page
	 */
	@PostMapping("/editPost")
	public String editPost(@Valid @ModelAttribute("postEditForm") Post post, BindingResult theBindingResult,
			HttpSession session) {
		int userId = (int) session.getAttribute("userId");
		post.setId((int) session.getAttribute("postId"));
		postService.insertPost(post, userId);
		return "redirect:/ManagePostPage/1";
	}
}
