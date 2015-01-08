package pl.ebla.mjbx.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import pl.ebla.mjbx.date.CurrentMonth;

@Entity
public class Month {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private Date startDate;
	private Date endDate;
	private Integer yearNumber;
	private Integer monthNumber;
	
	@OneToMany(mappedBy="month")
	private List<Post> posts;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public Integer getYearNumber() {
		return yearNumber;
	}
	public void setYearNumber(Integer yearNumber) {
		this.yearNumber = yearNumber;
	}
	public Integer getMonthNumber() {
		return monthNumber;
	}
	public void setMonthNumber(Integer monthNumber) {
		this.monthNumber = monthNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public void setCurrentMonth(CurrentMonth currMonth){
		
		this.name = currMonth.getMonthName();
		this.monthNumber = currMonth.getMonthNumber()+1;
		this.yearNumber = currMonth.getYearNumber();
		this.startDate = currMonth.getFirstDateOfMonth();
		this.endDate = currMonth.getLastDateOfMonth();
	}
	
	
}
