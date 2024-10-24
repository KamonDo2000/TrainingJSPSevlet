package fa.training.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.model.Post;
import fa.training.model.User;

/**
 * Class implement PostDao. This class consist of 7 function access with
 * database. 1. getAllPosts 2. insertPost 3. deletePost 4. getAllPostByUserId 5.
 * getPostByPostId 6. countPostByUserId 7. getAllPostByUserIdPaging
 * 
 * @author VuPH7
 *
 */
@Repository
public class PostDAOImpl implements PostDAO {

	// Declare SessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Function get all Post
	 * 
	 * @return List Post
	 */
	@Override
	public List<Post> getAllPosts() {
		try {
			// get Current session.
			Session session = sessionFactory.getCurrentSession();
			// get CriteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// create Query with Model Post.
			CriteriaQuery<Post> cq = cb.createQuery(Post.class);
			Root<Post> root = cq.from(Post.class);

			// Select all Post.
			cq.select(root);
			// create Query.
			Query query = session.createQuery(cq);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Function create new post or update old post
	 * 
	 * @param post
	 * @param userId
	 * 
	 */
	@Override
	public void insertPost(Post post, int userId) {
		// TODO Auto-generated method stub
		try {
			// get Current session.
			Session session = sessionFactory.getCurrentSession();
			// find user by userId
			User user = session.get(User.class, userId);
			// set this user
			post.setUser(user);
			// create or update this post
			session.saveOrUpdate(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * function delete post
	 * 
	 * @param post_id
	 * @return result
	 */
	@Override
	public boolean deletePost(int post_id) {
		try {
			// get Current session.
			Session session = sessionFactory.getCurrentSession();
			// create query call StoredProcedure
			StoredProcedureQuery storedProcedure = session.createNamedStoredProcedureQuery("deletePost");
			// set StoredProcedure parameter
			storedProcedure.setParameter("postId", post_id);
			// execute query
			storedProcedure.execute();
			// get StoredProcedure output
			boolean result = (boolean) storedProcedure.getOutputParameterValue("result");
			return result;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * function get all posts belong to user
	 * 
	 * @param user_id
	 * @return list post
	 */
	@Override
	public List<Post> getAllPostByUserId(int user_id) {
		try {
			// get Current session.
			Session session = sessionFactory.getCurrentSession();
			// get CriteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// create Query with Model Post.
			CriteriaQuery<Post> cq = cb.createQuery(Post.class);
			Root<Post> post = cq.from(Post.class);
			// join table user
			Join<User, Post> user = post.join("user");
			// select post by user_id
			cq.select(post).where(cb.equal(user.get("id"), user_id));
			// create query
			Query query = session.createQuery(cq);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * function get post by provide post id
	 * 
	 * @param post_id
	 * @return post
	 */
	@Override
	public Post getPostByPostId(int post_id) {
		try {
			return sessionFactory.getCurrentSession().get(Post.class, post_id);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * function get a number of post belong to this user
	 * 
	 * @param userId
	 * @return count;
	 */
	@Override
	public Long countPostByUserId(int userId) {
		try {
			// get Current session.
			Session session = sessionFactory.getCurrentSession();
			// get CriteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// create Query with Model Post.
			CriteriaQuery<Post> cq = cb.createQuery(Post.class);
			Root<Post> post = cq.from(Post.class);
			// join table user
			Join<User, Post> user = post.join("user");
			// select post by user_id
			cq.select(post).where(cb.equal(user.get("id"), userId));
			// create query
			Query query = session.createQuery(cq);

			if (query != null) {
				Long count = (long) query.getResultList().size();
				return count;
			}
			return 0L;
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * function get post in page
	 * 
	 * @param userId
	 * @param pageId
	 * @param sizePage
	 * @return list post
	 */
	@Override
	public List<Post> getAllPostByUserIdPaging(int userId, int pageId, int sizePage) {
		try {
			// get Current session.
			Session session = sessionFactory.getCurrentSession();
			// get CriteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// create Query with Model Post.
			CriteriaQuery<Post> cq = cb.createQuery(Post.class);
			Root<Post> post = cq.from(Post.class);
			// join table user
			Join<User, Post> user = post.join("user");
			// select post by user_id
			cq.select(post).where(cb.equal(user.get("id"), userId));
			// create query and set first result
			Query query = session.createQuery(cq).setFirstResult((pageId - 1) * sizePage);
			// set max result
			query.setMaxResults(sizePage);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
