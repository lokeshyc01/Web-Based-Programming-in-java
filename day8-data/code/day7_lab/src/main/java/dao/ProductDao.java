package dao;

import java.util.List;

import pojos.Product;

public interface ProductDao {
//add a method to insert new product details
	String addNewProduct(Product product);
	
	String addNewProductGetCurrentSession(Product product);
	
	String updateProductPrice(Integer productId,double priceOffset);
}
