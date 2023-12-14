package tester;

import java.util.List;
import java.util.Scanner;

import dao.ProductDaoImpl;
import pojos.Product;
import pojos.ProductCategory;

public class GetAllProductByCategory {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
			ProductDaoImpl productDao = new ProductDaoImpl();
			List<Product> list = productDao.getProductByCategory(ProductCategory.valueOf(sc.next().toUpperCase()));
			
			list.forEach(System.out::println);
		}catch(RuntimeException e)
		{
			e.printStackTrace();
		}
	}

}
