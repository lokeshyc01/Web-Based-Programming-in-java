package pojos;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student extends BaseEntity
{
	@Column(length=20)
	private String name;
	@Column(length=20,unique = true)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)    //default fetch type = EAGER
	@JoinColumn(name="course_id")
	private Course courseEnrolled;
	
	
	
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Student() {
		System.out.println("in constructor of "+getClass().getName());
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

	public Course getCourseEnrolled() {
		return courseEnrolled;
	}

	public void setCourseEnrolled(Course courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + "]";
	}
	
	
	
}
