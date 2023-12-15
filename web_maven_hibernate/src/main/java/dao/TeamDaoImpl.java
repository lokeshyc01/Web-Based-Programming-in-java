package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

import static utils.HibernateUtils.getFactory;

import java.util.List;

public class TeamDaoImpl implements TeamDao {
	private Session session;
	private Transaction tx;

	public int getTeamDetails(String team) {
		session = getFactory().getCurrentSession();
		tx = session.beginTransaction();
		Integer validateTeam = null;
		String jpql = "select t.id from Team t where t.abbreviation =:team";
		try {
			System.out.println(team);
			validateTeam = session.createQuery(jpql, Integer.class).setParameter("team",team).getSingleResult();
			System.out.println(validateTeam);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return validateTeam;
	}

	public List<String> getAbbreviation() {
		session = getFactory().getCurrentSession();
		tx = session.beginTransaction();
		List<String> list = null;
		String jpql = "select t.abbreviation from Team t";
		try {
			list = session.createQuery(jpql, String.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
				
			}
			throw e;
		}

		return list;
	}
}
