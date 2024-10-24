package fa.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class model User, map with table authorities
 * Declare fields of authorities, getter and setter, Constructor.
 * @author VuPH7
 *
 */
@Entity
@Table(name = "authorities")
public class Authorities {
	
	// Declare field id, auto generate.
	@Id
	private String authority;
	
	// Declare foreign key to table tbl_user
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	public Authorities() {
		
	}

	public Authorities(String name) {
		this.authority = name;
	}
	
	/**
	 * function get authority
	 * @return authority
	 */
	public String getAuthority() {
		return authority;
	}
	
	/**
	 * function set authority
	 * @param authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	/**
	 * function get user
	 * @return	user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * function set user
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
