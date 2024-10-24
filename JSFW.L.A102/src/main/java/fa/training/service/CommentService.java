package fa.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.CommentDAOImpl;
import fa.training.model.Comment;
import fa.training.model.Post;

/**
 * Class Comment Service, connect with commentDAOImpl, consist of 5 function:
 * 1 insertComment.
 * 2 getAllCommentsApproved.
 * 3 deleteComment.
 * 4 countAllCommentByUserId.
 * 5 getAllCommentsByUserIdPaging.
 * @author HoangLinh
 *
 */
@Service
public class CommentService {
	
	// Declare CommentDAOImpl.
	@Autowired
	private CommentDAOImpl commentDAO;

	/** 
	 * Call function insertComment in CommentDAO.
	 * 
	 * @param comment
	 */
	@Transactional
	public void insertComment(Comment comment, int post_id) {
		commentDAO.insertComment(comment, post_id);
	}

	/**
	 * Call function getAllCommentsApproved in CommentDAO.
	 * 
	 * @return List Comment
	 */
	@Transactional
	public List<Comment> getAllCommentsApproved() {
		return commentDAO.getAllCommentsApproved();
	}

	/**
	 * Call function getAllCommentsApproved in CommentDAO.
	 * @param status
	 * @param id_cmt
	 */
	@Transactional
	public void deleteComment(int status, int id_cmt) {
		commentDAO.deleteComment(status, id_cmt);
	}

	/**
	 * Call function countCommentApprovedByUser in CommentDAO.
	 * @param userId
	 * @return count
	 */
	@Transactional
	public Long countAllCommentByUserId(int userId) {
		return commentDAO.countCommentApprovedByUser(userId);
	}
	
	/**
	 * Call function getAllCommentsByUserIdPaging in CommentDAO.
	 * @param userId
	 * @param pageid
	 * @param pageSize
	 * @return List Comment
	 */
	@Transactional
	public List<Comment> getAllCommentsByUserIdPaging(int userId,int pageid, int pageSize){
		return commentDAO.getAllCommentsByUserIdPaging(userId, pageid, pageSize);
	}
	
	/**
	 * Call function listPostIdOfUser in CommentDAO.
	 * @param userId
	 * @return list Post.
	 */
	@Transactional
	public List<Post> getPostId(int userId){
		return commentDAO.listPostIdOfUser(userId);
	}
}
