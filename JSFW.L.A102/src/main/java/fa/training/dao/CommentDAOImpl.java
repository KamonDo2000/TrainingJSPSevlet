package fa.training.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.model.Comment;
import fa.training.model.Post;
import fa.training.model.User;

/**
 * Class implement CommentDao. This class consist of 6 function access with
 * database. 
 * 1 insertComment. 
 * 2 getAllCommentsApproved. 
 * 3 deleteComment. 
 * 4 countCommentByUserId. 
 * 5 getAllCommentByUserIdPaging. 
 * 6 selectCommentByUserId.
 * 
 * @author HoangLinh
 *
 */
@Repository
public class CommentDAOImpl implements CommentDAO {

	// Declare SessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Function insert comment into database
	 * 
	 * @param comment
	 */
	@Override
	public void insertComment(Comment comment, int post_id) {

		// Declare session.
		Session session = null;
		// get Current session
		session = sessionFactory.getCurrentSession();
		// get post with post_id
		Post post = session.get(Post.class, post_id);

		try {
			// transaction = session.beginTransaction();
			comment.setPost(post);
			// save Object comment in database
			session.saveOrUpdate(comment);
			// session.close();
		} catch (Exception e) {
			// if occur Exception, rollback;
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Function get all comment be approved
	 * 
	 * @return List Comment
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllCommentsApproved() {

		// Declare session.
		Session session = null;
		// Declare listComment.
		List<Comment> listComment = null;
		
		try {
			// get Current session.
			session = sessionFactory.getCurrentSession();

			// get CriteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();

			// create Query with Model Comment.
			CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);

			Root<Comment> root = cq.from(Comment.class);

			// Select Comment where status = 2.
			cq.select(root).where(cb.equal(root.get("status"), 2));

			// create Query.
			Query query = session.createQuery(cq);

			listComment = query.getResultList();
		} catch (Exception e) {
			// if occur Exception, rollback;
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		// return list Comment
		return listComment;
	}

	/**
	 * Function delete Comment by change status
	 * 
	 * @param status
	 * @param id_cmt
	 */
	@Override
	public void deleteComment(int status, int id_cmt) {

		// Declare session.
		Session session = null;
		try {
			// get current Session.
			session = sessionFactory.getCurrentSession();

			// Find comment by id.
			Comment comment = session.get(Comment.class, id_cmt);

			// set Status.
			comment.setStatus(status);

			// update comment.
			session.update(comment);
		} catch (Exception e) {
			// if occur Exception, rollback;
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Function count total comment in all post of user
	 * 
	 * @param userId
	 * @return count (type Long)
	 */
	@Override
	public Long countCommentApprovedByUser(int userId) {
		
		// Declare session.
		Session session = null;
		// Declare count.
		Long count = 0L;
		
		try {
			// get current Session.
			session = sessionFactory.getCurrentSession();
			// get criteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// create query with Comment table.
			CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
			// Select comment.
			Root<Comment> comment = cq.from(Comment.class);
			// join comment, post.
			Join<Comment, Post> post = comment.join("post");
			// get user.
			User user = session.get(User.class, userId);
			// Condition.
			cq.where(cb.equal(post.get("user"), user)).where(cb.equal(comment.get("status"), 2));
			// create query.
			Query query = session.createQuery(cq);
			// get count comment.
			count = (long) query.getResultList().size();
		} catch (Exception e) {
			// if occur Exception, rollback;
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * Function find all comment with constant size for paging
	 * 
	 * @param userId
	 * @param pageid
	 * @param pageSize
	 * @return List comment
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllCommentsByUserIdPaging(int userId, int pageid, int pageSize) {

		// Declare session.
		Session session = null;
		// Declare list comment.
		List<Comment> listComments = null;
		
		try {
			// get current Session.
			session = sessionFactory.getCurrentSession();
			// get criteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// create query with Comment table.
			CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
			// Select comment.
			Root<Comment> comment = cq.from(Comment.class);
			// join comment, post.
			Join<Comment, Post> post = comment.join("post");
			// get user.
			User user = session.get(User.class, userId);
			// Condition.
			cq.where(cb.equal(post.get("user"), user)).where(cb.equal(comment.get("status"), 2))
					.orderBy(cb.desc(comment.get("create_time")));
			// Order by post.
			cq.orderBy(cb.asc(comment.get("post")));
			
			// set row fist of result.
			Query query = session.createQuery(cq).setFirstResult((pageid - 1) * pageSize);
			
			// set max size of result.
			query.setMaxResults(pageSize);
			listComments = query.getResultList();
		} catch (Exception e) {
			// if occur Exception, rollback;
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return listComments;
	}

	@Override
	public List<Post> listPostIdOfUser(int userId) {
		
		// Declare session.
		Session session = null;
		// Declare list Post.
		List<Post> listPosts = null;
		try {
			// get current Session.
			session = sessionFactory.getCurrentSession();
			// get criteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// create query with Post table.
			CriteriaQuery<Post> cq = cb.createQuery(Post.class);
			// Select post.
			Root<Post> post = cq.from(Post.class);
			// Get user.
			User user = session.get(User.class, userId);
			// Condition.
			cq.orderBy(cb.asc(post.get("id"))).where(cb.equal(post.get("user"), user))
					.where(cb.isNotEmpty(post.get("comment")));
			// create query.
			Query query = session.createQuery(cq);
			// get list post
			listPosts = query.getResultList();
		} catch (Exception e) {
			// if occur Exception, rollback;
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return listPosts;
	}
}
