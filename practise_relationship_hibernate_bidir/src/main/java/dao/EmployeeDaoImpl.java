package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Department;
import pojos.Employee;
public class EmployeeDaoImpl implements EmployeeDao
{

	@Override
	public String addEmployeeToDepartment(int id, Employee e) {
		String mesg = "Employee not addded";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Department dept = session.get(Department.class,id);
			dept.addEmployee(e);
			
			tx.commit();
		}catch(RuntimeException ee)
		{
			if (tx != null)
				tx.rollback();
			throw ee;
		}

		return mesg;
	}
	
}
