package fa.training.dao;

import java.util.List;

import fa.training.model.Comment;
import fa.training.model.Post;

/**
 * Class CommentDAO.
 * This class consist of 5 function access with database.
 * 1 insertComment.
 * 2 getAllCommentsApproved.
 * 3 deleteComment.
 * 4 countCommentByUserId
 * 5 getAllCommentByUserIdPaging
 * 6 listPostIdOfUser
 * @author HoangLinh
 *
 */
public interface CommentDAO {

	/**
	 * Function insert comment into database
	 * @param comment
	 */
	public void insertComment(Comment comment, int post_id);
	
	/**
	 * Function get all comment be approved
	 * @return List Comment
	 */
	public List<Comment> getAllCommentsApproved();
	
	/**
	 * Function delete Comment by change status
	 * @param status
	 * @param id_cmt
	 */
	public void deleteComment(int status, int id_cmt);
	
	/**
	 * Function count total comment in all post of user
	 * @param userId
	 * @return count (type Long)
	 */
	public Long countCommentApprovedByUser(int userId);
	
	/**
	 * Function find all comment with constant size for paging
	 * @param userId
	 * @param pageid
	 * @param pageSize
	 * @return List comment
	 */
	public List<Comment> getAllCommentsByUserIdPaging(int userId,int pageid, int pageSize);
	
	/**
	 * Find posts of User
	 * @param userId
	 * @return listPost
	 */
	public List<Post> listPostIdOfUser(int userId);
	
}
