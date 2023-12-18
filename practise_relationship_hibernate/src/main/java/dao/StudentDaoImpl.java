package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

import java.util.List;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements StudentDao
{
	private Session session;
	private Transaction tx;
	
	public String takeAdmission(Student student,String courseName)
	{
		String msg = "Could not take Course";
		session = getFactory().getCurrentSession();
		tx = session.beginTransaction();
		String jpql = "select c from Course c where c.title=:courseName";
		try
		{
			Course course = session.createQuery(jpql,Course.class).setParameter("courseName", courseName).getSingleResult();
			student.setCourseEnrolled(course);
			session.persist(student);
			msg="admission taken";
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
	
	public List<Student> StudentByCourse(String courseName)
	{
		session = getFactory().getCurrentSession();
		tx = session.beginTransaction();
		List<Student> list = null;
//		String jpql = "select c from Course c where c.title=:courseName";
//		String jpql2 = "select s from Student s where s.courseEnrolled.title=:course";
		String jpql2 = "select s from Student s join fetch s.courseEnrolled c where c.title=:course";
		try {
			list =  session.createQuery(jpql2,Student.class).setParameter("course", courseName).getResultList();
			
//			list = session.createQuery(jpql2,Student.class).setParameter("course", course).getResultList();
		}catch(RuntimeException e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
