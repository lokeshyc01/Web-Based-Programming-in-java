package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.Session;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;
public class AddEmp {

	public static void main(String[] args) {
		
		try(Session session = getFactory().getCurrentSession();Scanner sc = new Scanner(System.in))
		{
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			System.out.println("name,email");
			Employee emp = new Employee(sc.next(), sc.next());
			System.out.println("id");
			empDao.addEmployeeToDepartment(sc.nextInt(), emp);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}

	}

}
