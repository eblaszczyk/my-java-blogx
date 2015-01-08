package pl.ebla.mjbx.wapper;

import pl.ebla.mjbx.date.Period;
import java.util.List;

import pl.ebla.mjbx.entity.Post;

public class PostAndViewWrapper {
	
	private Post post;
	private int beforePostId;
	private int afterPostId;
	private String categoryName;
	private List<String> monthsInArchive;
	private Period period;
	
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public int getBeforePostId() {
		return beforePostId;
	}
	public void setBeforePostId(int beforePostId) {
		this.beforePostId = beforePostId;
	}
	public int getAfterPostId() {
		return afterPostId;
	}
	public void setAfterPostId(int afterPostId) {
		this.afterPostId = afterPostId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<String> getMonthsInArchive() {
		return monthsInArchive;
	}
	public void setMonthsInArchive(List<String> monthsInArchive) {
		this.monthsInArchive = monthsInArchive;
	}
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	
	

}
