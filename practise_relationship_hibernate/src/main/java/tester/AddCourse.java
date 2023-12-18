package tester;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.Session;

import dao.CourseDaoImpl;
import pojos.Course;
public class AddCourse {

	public static void main(String[] args) {
		
		try(Session session = getFactory().getCurrentSession();Scanner sc = new Scanner(System.in))
		{
			System.out.println("String title, LocalDate startDate, LocalDate endDate, int fees, int capacity");
			Course course = new Course(sc.next(),LocalDate.parse(sc.next()),LocalDate.parse(sc.next()),sc.nextInt(),sc.nextInt());
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			System.out.println(courseDaoImpl.addCourse(course));
		}catch(RuntimeException e)
		{
			e.printStackTrace();
		}

	}

}
