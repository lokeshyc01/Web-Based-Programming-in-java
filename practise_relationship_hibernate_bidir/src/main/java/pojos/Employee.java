package pojos;
import javax.persistence.*;
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity
{
	@Column(length = 20)
	private String name;
	@Column(length=20,unique = true)
	private String email;
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department dept;
	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public Employee()
	{
		
	}
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
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
	
	
}
