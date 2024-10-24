package fa.training.dao;

import java.util.List;

import fa.training.model.Post;

/**
 * interface PostDao This interface consist of 7 function access with database.
 * 1. getAllPosts 2. insertPost 3. deletePost 4. getAllPostByUserId 5.
 * getPostByPostId 6. countPostByUserId 7. getAllPostByUserIdPaging
 * 
 * @author VuPH7
 *
 */
public interface PostDAO {
	/**
	 * Function create new post or update old post
	 * 
	 * @param post
	 * @param userId
	 * 
	 */
	public void insertPost(Post post, int userId);
	
	/**
	 * Function get all Post
	 * 
	 * @return List Post
	 */
	public List<Post> getAllPosts();
	
	/**
	 * function delete post
	 * 
	 * @param post_id
	 * @out result
	 */
	public boolean deletePost(int post_id);
	
	/**
	 * function get all posts belong to user
	 * 
	 * @param user_id
	 * @out list post
	 */
	List<Post> getAllPostByUserId(int user_id);
	
	/**
	 * function get post by provide post id
	 * 
	 * @param post_id
	 * @out post
	 */
	public Post getPostByPostId(int post_id);
	
	/**
	 * function get a number of post belong to this user
	 * 
	 * @param userId
	 * @out count;
	 */
	public Long countPostByUserId(int userId);
	
	/**
	 * function get post in page
	 * 
	 * @param userId
	 * @param pageId
	 * @param sizePage
	 * @out list post
	 */
	public List<Post> getAllPostByUserIdPaging(int userId, int pageId, int sizePage);
}
