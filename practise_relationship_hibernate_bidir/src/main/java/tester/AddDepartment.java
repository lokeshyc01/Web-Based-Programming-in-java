package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.Session;

import dao.DepartmentDaoImpl;
import pojos.Department;
public class AddDepartment {

	public static void main(String[] args) {
		
		try(Session session = getFactory().getCurrentSession();Scanner sc = new Scanner(System.in))
		{
			Department dept = new Department(sc.next(),sc.next());
			DepartmentDaoImpl deparmentDao = new DepartmentDaoImpl();
			System.out.println(deparmentDao.addDepartment(dept));
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}

	}

}
