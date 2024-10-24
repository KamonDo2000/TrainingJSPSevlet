package fa.training.dao;

import fa.training.model.User;

/**
 * Interface UserDetailsDao. This interface consist of 1 function access with database.
 * 1.findUserByUsername
 * @author VuPH7
 *
 */
public interface UserDetailsDao {
	
	/**
	 * function find user by username
	 * 
	 * @param username
	 * @return user
	 */
	User findUserByUsername(String username);
}
