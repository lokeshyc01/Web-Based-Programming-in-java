package dao;
import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
public class PlayerDaoImpl implements PlayerDao {
	private Session session;
	private Transaction tx;
	
	@Override
	public void addPlayer(Player player) 
	{
		session = getFactory().getCurrentSession();
		tx = session.beginTransaction();
		try
		{
			System.out.println(player);
			session.save(player);			
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
