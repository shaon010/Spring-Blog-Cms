package org.mpb.entity;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user_comments")
public class Comment {

	@Id
	@GeneratedValue
	private Integer id;

	//TODO add custom validation for mail-> http://stackoverflow.com/questions/4459474/hibernate-validator-email-accepts-askstackoverflow-as-valid

	@NotEmpty
	@Column(length = Integer.MAX_VALUE)
	private String email;

	@NotEmpty
	@Column(length = Integer.MAX_VALUE)
	private String name;

	@NotEmpty
	@Column(length = Integer.MAX_VALUE)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "published_date")//columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	private Date publishedDate;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
