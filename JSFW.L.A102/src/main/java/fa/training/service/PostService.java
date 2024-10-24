package fa.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.PostDAOImpl;
import fa.training.model.Post;

/**
 * Class Post Service, connect with PostDAOImpl, consist of 7 function: 1.
 * getAllPosts 2. insertPost 3. deletePost 4. getAllPostByUserId 5.
 * getPostByPostId 6. countPostByUserId 7. getAllPostByUserIdPaging
 * 
 * @author VuPH7
 *
 */
@Service
public class PostService {

	// Declare PostDAOImpl
	@Autowired
	private PostDAOImpl postDAO;

	/**
	 * Function get all Post
	 * 
	 * @return List Post
	 */
	@Transactional
	public List<Post> getAllPost() {
		return postDAO.getAllPosts();
	}

	/**
	 * Function create new post or update old post
	 * 
	 * @param post
	 * @param userId
	 */
	@Transactional
	public void insertPost(Post post, int userId) {
		postDAO.insertPost(post, userId);
	}

	/**
	 * function delete post
	 * 
	 * @param post_id
	 * @return boolean
	 */
	@Transactional
	public boolean deletePost(int post_id) {
		return postDAO.deletePost(post_id);
	}

	/**
	 * function get all posts belong to user
	 * 
	 * @param user_id
	 * @return list post
	 */
	@Transactional
	public List<Post> getAllPostByUserId(int user_id) {
		return postDAO.getAllPostByUserId(user_id);
	}

	/**
	 * function get post by provide post id
	 * 
	 * @param post_id
	 * @return post
	 */
	@Transactional
	public Post getPostByPostId(int post_id) {
		return postDAO.getPostByPostId(post_id);
	}

	/**
	 * function get post in page
	 * 
	 * @param userId
	 * @param pageId
	 * @param sizePage
	 * @return list post
	 */
	@Transactional
	public List<Post> getAllPostByUserIdPaging(int userId, int pageId, int sizePage) {
		return postDAO.getAllPostByUserIdPaging(userId, pageId, sizePage);
	}

	/**
	 * function get a number of post belong to this user
	 * 
	 * @param userId
	 * @return long
	 */
	@Transactional
	public Long countPostByUserId(int userId) {
		return postDAO.countPostByUserId(userId);
	}
}
