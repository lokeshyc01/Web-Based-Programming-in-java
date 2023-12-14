package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
public class UpdateProductPrice {
	public static void main(String arr[])
	{
		try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
			ProductDaoImpl productDao =  new ProductDaoImpl();
			
			System.out.println(productDao.updateProductPrice(sc.nextInt(), sc.nextDouble()));
		}
	}
}
