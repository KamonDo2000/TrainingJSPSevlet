package fa.training.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Class model Post, map with table tbl_post Declare fields of tbl_post, getter
 * and setter, Constructor.
 * 
 * @author VuPH7
 *
 */
@Entity
@Table(name = "tbl_post")

// Declare stored procedure
@NamedStoredProcedureQuery(name = "deletePost", procedureName = "deletePost", parameters = {
		@StoredProcedureParameter(name = "postId", type = Integer.class, mode = ParameterMode.IN),
		@StoredProcedureParameter(name = "result", type = Boolean.class, mode = ParameterMode.OUT) })
public class Post {

	// Declare field id, auto generate.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// Declare field title
	@Column(name = "title")
	private String title;

	// Declare field content
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	// Declare field tags
	@Column(name = "tags")
	private String tags;

	// Declare field status
	@Column(name = "status")
	private int status;

	// Declare field create_time can not be update
	@Column(name = "create_time", updatable = false)
	@CreationTimestamp
	private Date create_time;

	// Declare field update_time
	@Column(name = "update_time")
	@UpdateTimestamp
	private Date update_time;

	// Declare foreign key to table tbl_user
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User user;

	// Declare foreign key from table tbl_comment
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.LAZY)
	private List<Comment> comment = new ArrayList<>();

	/**
	 * Constructor
	 */
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param title
	 * @param content
	 * @param tags
	 * @param status
	 * @param create_time
	 * @param update_time
	 * @param user
	 */
	public Post(int id, String title, String content, String tags, int status, Date create_time, Date update_time,
			User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.tags = tags;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
		this.user = user;
	}

	/**
	 * function get id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * function set id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * function get title
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * function set title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * function get content
	 * 
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * function set content
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * function get tags
	 * 
	 * @return tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * function set tags
	 * 
	 * @param tags
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * function get status
	 * 
	 * @return status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * function set status
	 * 
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * function get create time
	 * 
	 * @return create_time
	 */
	public Date getCreate_time() {
		return create_time;
	}

	/**
	 * function set create time
	 * 
	 * @param create_time
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * function get update time
	 * 
	 * @return update_time
	 */
	public Date getUpdate_time() {
		return update_time;
	}

	/**
	 * function set update time
	 * 
	 * @param update_time
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * function get user
	 * 
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * function set user
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * function get all comments
	 * 
	 * @return list comment
	 */
	public List<Comment> getComment() {
		return comment;
	}

	/**
	 * function get all comments
	 * 
	 * @param comment
	 */
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

}
