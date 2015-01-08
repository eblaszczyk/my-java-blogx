package pl.ebla.mjbx.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=3, message = "Nazwa kategorii nie mo¿e byæ krótsza ni¿ 3 znaki")
	private String categoryName;
	
	@Size(min=10, message = "Opis kategorie nie mo¿e byæ krótszy ni¿ 10 znaków")
	private String description;
	
	@ManyToMany
	@JoinTable
	private List<Post> posts;
	
	private Boolean shown;
	
	public Boolean getShown() {
		return shown;
	}
	public void setShown(Boolean shown) {
		this.shown = shown;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
