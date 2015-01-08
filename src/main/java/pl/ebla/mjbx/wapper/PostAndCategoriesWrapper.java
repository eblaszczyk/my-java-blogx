package pl.ebla.mjbx.wapper;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import pl.ebla.mjbx.entity.Post;

public class PostAndCategoriesWrapper {
	
	
	@Valid
	private Post post;
	
	@NotNull
	private  List<String> categoriesList;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<String> getCategoriesList() {
		return categoriesList;
	}

	public void setCategoriesList(List<String> categoriesList) {
		this.categoriesList = categoriesList;
	}


/*
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
*/
}
