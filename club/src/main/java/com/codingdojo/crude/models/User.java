package com.codingdojo.crude.models;





import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotEmpty
	 @Size(min=2, max=25)
	 private String fname;
	 
	 
	 @NotEmpty
	 @Size(min=2, max=25)
	 private String lname;
	 
	 @NotEmpty
	 @Email
	 private String email;
	 
	 
	 @NotEmpty
	 @Size(min=2, max=125)
	 private String password;
	 
	 
	@Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;

	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	 
	 @Transient
	 @NotEmpty
	 @Size(min=8, max=125)
	 private String confirm;
	 
	 @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	 private List<Book> books;

	 
	 public User() {}


	public User(@NotEmpty @Size(min = 2, max = 25) String fname, @NotEmpty @Size(min = 2, max = 25) String lname,
			@NotEmpty @Email String email, @NotEmpty @Size(min = 2, max = 125) String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}


	public User(@NotEmpty @Size(min = 2, max = 25) String fname, @NotEmpty @Size(min = 2, max = 25) String lname,
			@NotEmpty @Email String email, @NotEmpty @Size(min = 2, max = 125) String password, List<Book> books) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.books = books;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}
	 
	 
	//and getters removed for brevity
	   @PrePersist
	   protected void onCreate(){
	       this.createdAt = new Date();
	   }
	   @PreUpdate
	   protected void onUpdate(){
	       this.updatedAt = new Date();
	       
	       
	       
	   }
	 
	 
	 
}
