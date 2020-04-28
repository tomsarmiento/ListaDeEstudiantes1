package springdata2.studentslist.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=2)
	private String firstName;
	@Size(min=2)
	private String lastName;
	private int age;
	@Column(updatable=false)
	private LocalDateTime createdAt;
	@OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Contact contact;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, int age, Contact contact) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}
	
	
}
