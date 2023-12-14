package dao;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Product;
import pojos.ProductCategory;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addNewProduct(Product product) {
		String mesg="Adding product failed!!!!";
		// 1. get Session from SessionFactory (SF)
		Session session = getFactory().openSession();
		// 2. Begin a Transaction
		Transaction tx = session.beginTransaction();
		// 3 . try-catch -finally
		try {
			session.save(product);
			// success : commit tx
			tx.commit();
			mesg="product added with ID "+product.getProductId();
		} catch (RuntimeException e) {
			// error : rollback tx
			if (tx != null)
				tx.rollback();
			// re throw the SAME exc to the caller : to inform about the error
			throw e;
		} finally {
			if (session != null)
				session.close();// L1 cache is destroyed , 
			//pooled out db cn rets back to the pool
		}
		return mesg;
	}
	
	public String addNewProductGetCurrentSession(Product product)
	{
		String msg = "added product details";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.save(product);
			
			tx.commit();
			
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			msg = "could not add product details";
			throw e;
		}
		return msg;
	}
	
	public List<Product> getAllProduct()
	{
		List<Product> list = null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		String jpql = "select p from Product p";
		try
		{
			list = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
			tx.rollback();
			throw e;
		}
		return list;
	}
	
//	Get all products from a specific product category
//	i/p : product category
	
	public List<Product> getProductByCategory(ProductCategory category)
	{
		List<Product> list = null;
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		String jpql = "select p from Product p where p.category =:category";
		
		try
		{
			list = session.createQuery(jpql,Product.class).setParameter("category", category).getResultList();
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return list;
	}
	
	public List<Product> getProductAfterDate(LocalDate date)
	{
		List<Product> list = null;
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		String jpql = "select new pojos.Product(productId,name,price,stock) from Product p where p.manufactureDate > : date";
		
		try
		{
			list = session.createQuery(jpql,Product.class).setParameter("date", date).getResultList();
		}catch(RuntimeException e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			throw e;
		}
		return list;
	}
	
	public String updateProductPrice(Integer productId,double priceOffset)
	{
		String msg = "price updation failed";
		Product product = null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			product = session.get(Product.class, productId);
			if(product != null)
			{
				product.setPrice(product.getPrice() + priceOffset);
				msg = "product price updated...";
			}
			tx.commit(); //session.flush --> auto dirty checking --> updated entity --> 
//			DML : update
//			session.close() --> L1 cache is destroyed n pooled out
//			database connection returns to the pool
		}
		catch(RuntimeException e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			throw e;
		}
		
		return "Product not found !! unable to update price";
	}
}
