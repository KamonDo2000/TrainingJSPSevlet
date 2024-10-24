package fa.training.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class model User, map with table tbl_user
 * Declare fields of tbl_user, getter and setter, Constructor.
 * @author VuPH7
 *
 */
@Entity
@Table(name = "tbl_user")
public class User {
	
	// Declare field id, auto generate.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	// Declare field username
	@Column(name = "username")
	private String username;

	// Declare field password
	@Column(name = "password")
	private String password;

	// Declare field email
	@Column(name = "email")
	private String email;

	// Declare field profile
	@Column(name = "profile")
	private String profile;
		
	// Declare foreign key authorities table
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private Collection<Authorities> authorities;
	
	// Declare foreign key post table
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)     
	private Set<Post> post = new HashSet<>();
	
	/**
	 * constructor 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * constructor
	 * @param id
	 * @param username
	 * @param password
	 * @param email
	 * @param profile
	 * @param authorities
	 */
	public User(int id, String username, String password, String email, String profile,
			Set<Authorities> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
		this.authorities = authorities;
	}
	
	/**
	 * function get id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * function set id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * function get username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * function set username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * function get password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * function set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * function get email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * function set email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * function get profile
	 * @return	profile
	 */
	public String getProfile() {
		return profile;
	}
	
	/**
	 * function set profile
	 * @param profile
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	/**
	 * function get authority
	 * @return authorities
	 */
	public Collection<Authorities> getAuthorities() {
		return authorities;
	}
	
	/**
	 * function set authority
	 * @param authorities
	 */
	public void setAuthorities(Collection<Authorities> authorities) {
		this.authorities = authorities;
	}
	
	/**
	 * function get all post belong this user
	 * @return post
	 */
	public Set<Post> getPost() {
		return post;
	}
	
	/**
	 * function set post belong this user
	 * @param post
	 */
	public void setPost(Set<Post> post) {
		this.post = post;
	}

}
