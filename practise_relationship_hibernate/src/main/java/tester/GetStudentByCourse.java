package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.Session;

import dao.StudentDaoImpl;
import pojos.Student;

public class GetStudentByCourse {

	public static void main(String[] args) {
		try(Session session = getFactory().getCurrentSession();Scanner sc = new Scanner(System.in))
		{
			StudentDaoImpl studentDao = new StudentDaoImpl();
			studentDao.StudentByCourse(sc.next()).forEach(System.out::println);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}
	}

}
