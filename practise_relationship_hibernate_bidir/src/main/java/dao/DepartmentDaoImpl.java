package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;
import pojos.Department;

public class DepartmentDaoImpl implements DepartmentDao
{
	private Session session;
	private Transaction tx;
	
	public String addDepartment(Department dept)
	{
		String msg = "department not added";
		session = getFactory().getCurrentSession();
		tx = session.beginTransaction();
		
		try
		{
			session.persist(dept);
			tx.commit();
			msg = "Department added";
		}catch(RuntimeException e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}
	
	public Department getDepartmentByName(String deptName)
	{
		session = getFactory().getCurrentSession();
		tx = session.beginTransaction();
		Department dept = null;
//		String jpql = "select d from Department d where d.name=:name";
		String jpql = "select d from Department d join fetch d.list where d.name =: deptName";
		try
		{
			 dept = session.createQuery(jpql,Department.class).setParameter("name", deptName).getSingleResult();
//			 dept.getEmp().size();		//hibernates fires multiple queries;
			 
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			throw e;
		}
		return dept;
	}
}
