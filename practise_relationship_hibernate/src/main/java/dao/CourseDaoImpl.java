package dao;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class CourseDaoImpl implements CourseDao
{
	private Session session;
	private Transaction tx;
	
	public String addCourse(Course course)
	{
		String msg = "Could not add Course";
		session = getFactory().getCurrentSession();
		tx = session.beginTransaction();
		
		try
		{
			session.persist(course);
			msg="course added";
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			
			e.printStackTrace();
		}
		return msg;
	}
	
	
}
