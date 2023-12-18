package tester;
import static utils.HibernateUtils.getFactory;
import java.util.Scanner;
import org.hibernate.Session;
import dao.StudentDaoImpl;
import pojos.Student;

public class TakeCourse {
	public static void main(String[] args) {
		try(Session session = getFactory().getCurrentSession();Scanner sc = new Scanner(System.in))
		{
			System.out.println("name, email");
			Student student = new Student(sc.next(),sc.next());
			System.out.println("Enter course name");
			String courseName = sc.next();
			
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println(studentDao.takeAdmission(student, courseName));
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}
	}

}
