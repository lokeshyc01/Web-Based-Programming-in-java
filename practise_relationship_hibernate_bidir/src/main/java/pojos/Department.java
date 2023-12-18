package pojos;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "department")
public class Department extends BaseEntity
{
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String location;
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL) //fetch = EAGER not recommended
	private List<Employee> list;

	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	public List<Employee> getEmp()
	{
		return this.list;
	}
		
	public Department() {
		super();
	}


	public String getName() {
		return name;
	}
	
	public void addEmployee(Employee emp)
	{
		this.list.add(emp);
		emp.setDept(this);
	}
	
	public void removeEmployee(Employee emp)
	{
		this.list.remove(emp);
		emp.setDept(null);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
	
	
}
