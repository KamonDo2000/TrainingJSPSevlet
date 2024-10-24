package fa.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.dao.UserDetailsDao;
import fa.training.dto.UserDetailsDTO;
import fa.training.model.User;

/**
 * Class UserDetails Service,  consist of 1 function:
 * 1. loadUserByUsername
 * @author VuPH7
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

	private static final Logger Log = LoggerFactory.getLogger(UserDetailsServiceImp.class);
	
	// Declare UserDetailDao
	@Autowired
	 private UserDetailsDao userDetailsDao;
	
	/**
	 * function get user by username
	 * @param username
	 * @return user detail
	 */
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDetailsDao.findUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		} else {
			Log.info("loadUserByUsername() : {}", username);
			return new UserDetailsDTO(user);
		}
	}

}
