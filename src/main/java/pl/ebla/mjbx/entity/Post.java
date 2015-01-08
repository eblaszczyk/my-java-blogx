package pl.ebla.mjbx.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;




@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank(message = "Tytu³ nie mo¿e byæ pusty")
	@Column(length=300)
	private String title;
	
	@NotBlank(message = "Streszczenie nie mo¿e byæ puste")
	@Column(length=1000)
	private String shortCut;
	
	@NotBlank(message = "Treœæ nie mo¿e byæ pusta")
	@Lob
	@Type(type="org.hibernate.type.StringClobType")
	@Column(length=Integer.MAX_VALUE)
	private String body;
	private Boolean published;
	private Date publishedAt;

	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany()
	private List<Category> categories;
	
	@OneToMany(mappedBy="post")
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name="month_id")
	private Month month;

	public Month getMonth() {
		return month;
	}
	
	public void setMonth(Month month) {
		this.month = month;
	}
	
	public Boolean getPublished() {
		return published;
	}
	public void setPublished(Boolean published) {
		this.published = published;
	}
	public Date getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortCut() {
		return shortCut;
	}
	public void setShortCut(String shortCut) {
		this.shortCut = shortCut;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<String> getCategoriesName() {
		
		List<String> categoriesName = new ArrayList<String>();
		
		for(Category c : categories)
			 categoriesName.add(c.getCategoryName());
		
		return categoriesName;
	}
	
	public void changePost( Post post, List<Category> categoriesList ){
		
		Date now = new Date();
		this.setTitle( post.getTitle() );
		this.setBody( post.getBody());
		this.setShortCut( post.getShortCut() );
		this.setCategories( categoriesList );
		this.setUpdatedAt( now );
		
		Boolean isPublished = post.getPublished();
		
		if( !this.published && isPublished ){
			this.setPublishedAt(now);
		}
		else if( this.published && !isPublished){
			this.setPublishedAt(null);
		}
			
		this.setPublished( isPublished );
	}
	
	public void setUp(List<Category> categoriesList, User user, Month month) {

		Date now = new Date();	
		
		this.setCreatedAt(now);
		this.setUpdatedAt(now);
		if(this.getPublished())
			this.setPublishedAt(now);
		
		this.setCategories(categoriesList);
		this.setUser(user);
		this.setMonth(month);
			
	}

}
