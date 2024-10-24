package fa.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.UserDAO;
import fa.training.model.User;

/**
 * Class User Service, connect with UserDAOImpl, consist of 3 function:
 * 1. getUsers 2. createUser 3. findUserByUsername
 * @author VuPH7
 *
 */
@Service
public class UserService {
	
	// Declare UserDAO
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * function get all user
	 * @return list user
	 */
	@Transactional
	public List<User> getUsers() {
		return userDAO.getAllUsers();
	}

	/**
	 * function create user
	 * @param user
	 */
	@Transactional
	public void createUser(User user) {
		userDAO.createUser(user);
	}
	
	/**
	 * function find user by username
	 * @param username
	 * @return user
	 */
	@Transactional
	public User findUserByUsername(String username) {
		return userDAO.findUserByUsername(username);
	}
}
