package tester;

import java.util.List;

import dao.ProductDaoImpl;
import pojos.Product;

public class GetAllProduct {

	public static void main(String[] args) {
		try{
			ProductDaoImpl productDao = new ProductDaoImpl();
			
			List<Product> list = productDao.getAllProduct();
			list.forEach(p->System.out.println(p));
		}
		catch(RuntimeException e)
		{
			
			e.printStackTrace();
		}
		

	}

}
