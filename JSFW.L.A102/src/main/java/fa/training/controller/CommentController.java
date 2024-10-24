package fa.training.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.model.Comment;
import fa.training.model.Post;
import fa.training.service.CommentService;

/**
 * This Class Comment Controller Consist of many mapping process functions.
 * Comment: ManageComment, saveComment, deleteComment.
 * 
 * @author HoangLinh
 *
 */
@Controller
public class CommentController {

	// Declare Service Comment
	@Autowired
	private CommentService commentService;

	/**
	 * function Get Mapping with direct: /ManageCommentPage/{page_id}. Show all
	 * comment in all post of user
	 * 
	 * @param comment.
	 * @param session.
	 * @param page_id.
	 * @return ManagePostPage page
	 */
	@GetMapping(value = { "/ManageCommentPage/{page_id}" })
	public String manageCommentPage(Model comment, HttpSession session, @PathVariable int page_id) {

		// Declare Id user.
		int userId = (int) session.getAttribute("userId");

		// Declare total Comment in all post of user.
		Long total = (Long) session.getAttribute("totalComment");

		// Declare row in each page.
		int pageSize = 15;

		// Declare total page.
		int listPage = 0;

		// find total page.
		if (total % pageSize > 0) {
			listPage = (int) (total / pageSize + 1);
		} else {
			listPage = (int) (total / pageSize);
		}

		// fetch paging.
		List<Comment> listComments = commentService.getAllCommentsByUserIdPaging(userId, page_id, pageSize);
		List<Post> postUser = commentService.getPostId(userId);
		List<Post> listPosts = new ArrayList<Post>();
		
		// check null
		if (listComments != null && postUser != null) {
			// find post display
			for (Post p : postUser) {
				for (Comment c : listComments) {
					if (p.getId() == c.getPost().getId()) {
						listPosts.add(p);
						break;
					}
				}
			}
			
			// add attribute for model comment.
			comment.addAttribute("listComments", listComments);
			comment.addAttribute("listPosts", listPosts);
			comment.addAttribute("totalPage", listPage);
			comment.addAttribute("page_id", page_id);
		}
		
		// Return manageCommentPage.jsp
		return "ManageCommentPage";
	}

	/**
	 * Function Post Mapping with direct: /saveComment Save Comment of Member or
	 * Guest
	 * 
	 * @param comment
	 * @param session
	 * @return index page
	 */
	@PostMapping("/saveComment")
	public String insertComment(@ModelAttribute("commentForm") Comment comment, @RequestParam int post_id,
			HttpSession session) {

		// insert comment.
		commentService.insertComment(comment, post_id);

		// count all comment if user login.
		if (session.getAttribute("userId") != null)
			session.setAttribute("totalComment",
					commentService.countAllCommentByUserId((int) session.getAttribute("userId")));

		// return index.jsp.
		return "redirect:/index";
	}

	/**
	 * Function GET mapping /ManageCommentPage/{page_id}/delete User can delete
	 * comment by change status field.
	 * 
	 * @param idCmt
	 * @param session
	 * @return /ManageCommentPage/{page_id}
	 */
	@GetMapping("/ManageCommentPage/{page_id}/delete")
	public String deleteComment(@RequestParam("cmtId") int idCmt, HttpSession session) {

		// call service delete comment with id comment
		commentService.deleteComment(1, idCmt);

		// count all comment in all post of user
		session.setAttribute("totalComment",
				commentService.countAllCommentByUserId((int) session.getAttribute("userId")));

		// return manageCommentPage.jcp
		return "redirect:/ManageCommentPage/{page_id}";
	}
}
