package tester;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.ProductDaoImpl;
import pojos.Product;

public class ProductAfterDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc = new Scanner(System.in))
		{
			ProductDaoImpl productDao = new ProductDaoImpl();
			
			List<Product> list = productDao.getProductAfterDate(LocalDate.parse(sc.next()));
			list.forEach(System.out::println);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}
	}

}
