package pojos;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity
{
	@Column(length = 10,unique = true)
	private String title;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	private int fees;
	private int capacity;
	
	
	
	public Course(String title, LocalDate startDate, LocalDate endDate, int fees, int capacity) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}

	public Course() {
		System.out.println("In Constructor of "+getClass().getName());
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() 
	{
		return "Course [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", fees=" + fees
				+ ", capacity=" + capacity + "]";
	}
}
