package fa.training.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fa.training.model.User;


/**
 * Class UserDetailsDTO implements UserDeatails This class consist of 9
 * function. 1. UserDetailsDTO 2.getAuthorities 3.getUserDetails 4.getPassword
 * 5.getUsername 6.isAccountNonExpired 7.isAccountNonLocked
 * 8.isCredentialsNonExpired 9.isEnabled
 * 
 * @author VuPH7
 *
 */
public class UserDetailsDTO implements UserDetails {
	
	// Declare User
	private User user;
	
	/**
	 * Constructor 
	 * @param user
	 */
	public UserDetailsDTO(User user) {
		this.user = user;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * function get authority
	 * @return authority
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return user.getAuthorities().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getAuthority().toString()))
				.collect(Collectors.toList());
	}
	
	/**
	 * function get detail of user
	 * @return user
	 */
	public User getUserDetails() {
		return user;
	}
	
	/**
	 * function get password
	 * @return password
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}
	
	/**
	 * fuction get username
	 * @return username
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	
	/**
	 * function set AccountNonExpired
	 * @return true
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * function set AccountNonLocked
	 * @return true
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * function set CredentialsNonExpired
	 * @return true
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * function set AccountEnabled
	 * @return true
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
