package dao;
import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;
public class PlayerDaoImpl implements PlayerDao {
	private Session session;
	private Transaction tx;
	
	
	
	
	@Override
	public void addPlayer(Player player,int teamId) 
	{
		session = getFactory().getCurrentSession();
		tx = session.beginTransaction();
		try
		{
			Team team = session.get(Team.class, teamId);
			team.addPlayer(player);
//			session.persist(player);			
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			throw e;
		}
	}

}
