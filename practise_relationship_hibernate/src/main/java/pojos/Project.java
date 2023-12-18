package pojos;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
@Entity
@Table(name="projects")
public class Project extends BaseEntity{
	@Column(name = "project_title",length=30,unique = true)
	private String projectTitle;
	@Column(length=200)
	private String technology;
	@Column(name="completion_date")
	private LocalDate completionDate;
//	many to many uni dir association between entities
	@ManyToMany //mandatory
	@JoinTable(name = "project_student",
	joinColumns = @JoinColumn(name="project_id"),
	inverseJoinColumns = @JoinColumn(name="student_id"))
	private Set<Student> students = new HashSet<>();
	
	public Project()
	{
		System.out.println("in constructor of " +getClass().getName());
	}

	@Override
	public String toString() {
		return "Project [projectTitle=" + projectTitle + ", technology=" + technology + ", completionDate="
				+ completionDate + ", students=" + students + "]";
	}
	
	
}
