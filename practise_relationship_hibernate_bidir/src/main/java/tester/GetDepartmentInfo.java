package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.Session;

import dao.DepartmentDaoImpl;
import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;

public class GetDepartmentInfo {

	public static void main(String[] args) {
		try(Session session = getFactory().getCurrentSession();Scanner sc = new Scanner(System.in))
		{
			DepartmentDaoImpl empDao = new DepartmentDaoImpl();
			System.out.println("department name");
			System.out.println(empDao.getDepartmentByName(sc.next()).getEmp());
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}

	}

}
