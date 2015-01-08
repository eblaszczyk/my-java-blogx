package pl.ebla.mjbx.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import pl.ebla.mjbx.annotation.UniqueUserName;

@Table(name="app_user")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank(message = "Nazwa u¿ytkownika nie mo¿e byæ pusta")
	@Column(unique = true)
	@UniqueUserName(message = "U¿ytkownik o takiej nazwie ju¿ istnieje")
	private String name;	
	private String firstName;	
	private String lastName;	
	
	@Size(min=1, message="Nie poprawny adres email")
	@Email(message = "Nie poprawny adres email")
	private String email;
	
	@NotBlank(message = "Has³o nie mo¿e byæ puste")
	@Size(min=5, message ="Has³o powinno mieæ co najmniej 5 znaków")
	private String password;
	
	private String about;
	
	private boolean enabled;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;

	@OneToMany(mappedBy="user", cascade = CascadeType.REMOVE)
	private List<Post> posts;
	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwd) {
		this.password = passwd;
	}

	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void copy(User userCopyFrom){
		
		this.firstName = userCopyFrom.getFirstName();
		this.lastName = userCopyFrom.getLastName();
		this.email = userCopyFrom.getEmail();
		this.about = userCopyFrom.getAbout();
	}
	
	
	
}
