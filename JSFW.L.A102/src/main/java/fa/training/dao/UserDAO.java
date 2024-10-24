package fa.training.dao;

import java.util.List;

import fa.training.model.User;

/**
 * Interface UserDAO This interface consist of 3 function access with database.
 * 1.getAllUsers 2. createUser 3. findUserByUsername
 * 
 * @author VuPH7
 *
 */
public interface UserDAO {
	
	/**
	 * function get all user.
	 * 
	 * @return list user
	 */
	public List<User> getAllUsers();
	
	/**
	 * function create new user
	 * 
	 * @param user
	 */
	public void createUser(User user);
	
	/**
	 * function find user by username
	 * 
	 * @param username
	 * @return user
	 */
	public User findUserByUsername(String username);

}
