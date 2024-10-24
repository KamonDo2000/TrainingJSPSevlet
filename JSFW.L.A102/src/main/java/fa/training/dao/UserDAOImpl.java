package fa.training.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.model.User;

/**
 * Class UserDAOImpl This class consist of 3 function access with database.
 * 1.getAllUsers 2. createUser 3. findUserByUsername
 * 
 * @author VuPH7
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	// Declare SessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * function get all user.
	 * 
	 * @return list user
	 */
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		try {
			// get Current session.
			Session session = sessionFactory.getCurrentSession();
			// get CriteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// create Query with Model User.
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			// select query
			cq.select(root);
			// create query
			Query query = session.createQuery(cq);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * function create new user
	 * 
	 * @param user
	 */
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		try {
			// get Current session.
			Session sesssion = sessionFactory.getCurrentSession();
			// create new user
			sesssion.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * function find user by username
	 * 
	 * @param username
	 * @return user
	 */
	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		try {
			// get Current session.
			Session session = sessionFactory.getCurrentSession();
			// get CriteriaBuilder.
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// create Query with Model User.
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			// select query
			cq.select(root).where(cb.equal(root.get("username"), username));
			// create query
			Query query = session.createQuery(cq);
			
			if (query.getResultList().size() == 0) {
				return null;
			}
			User user = (User) query.getResultList().get(0);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}
