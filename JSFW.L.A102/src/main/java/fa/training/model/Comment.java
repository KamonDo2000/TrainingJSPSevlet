package fa.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
/**
 * Class model Comment, map with table tbl_comment
 * Declare fields of tbl_comment, getter and setter, Constructor.
 * @author HoangLinh
 *
 */
@Entity
@Table(name = "tbl_comment")
public class Comment {
	
	// Declare field id, auto generate.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// Declare field content.
	@Column(name = "content")
	private String content;

	// Declare field status.
	@Column(name = "status")
	private int status;

	// Declare field create_time, auto create and update not enable.
	@Column(name = "create_time", updatable = false)
	@CreationTimestamp
	private Date create_time;

	// Declare field author.
	@Column(name = "author")
	private String author;

	// Declare field eamil.
	@Column(name = "email")
	private String email;

	// Declare field url.
	@Column(name = "url")
	private String url;
	
	// Declare field post_id.
	@ManyToOne   
	@JoinColumn(name = "post_id")    
	private Post post;
	/**
	 * Constructor Comment without fields.
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor Comment with Fields
	 * @param id
	 * @param content
	 * @param status
	 * @param create_time
	 * @param author
	 * @param email
	 * @param url
	 * @param post_id
	 */
	public Comment(int id, String content, int status, Date create_time, String author, String email, String url,
			Post post) {
		super();
		this.id = id;
		this.content = content;
		this.status = status;
		this.create_time = create_time;
		this.author = author;
		this.email = email;
		this.url = url;
		this.post = post;
	}
	
	/**
	 * Function getter Id.
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Function setter id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Function getter Content.
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Function setter content
	 * @param id
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Function getter status.
	 * @return content
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Function setter status.
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Function getter create_time.
	 * @return create_time
	 */
	public Date getCreate_time() {
		return create_time;
	}

	/**
	 * Function setter create_time.
	 * @param create_time
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * Function getter create_time.
	 * @return create_time
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Function setter author.
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Function getter email.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Function setter email.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Function getter url.
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Function setter url.
	 * @return url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Function getter Post.
	 * @return Post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * Function setter Post.
	 * @return Post
	 */
	public void setPost(Post post) {
		this.post = post;
	}
}
