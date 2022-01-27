package myproject.northwind.business.abstracts;

import java.util.List;

import myproject.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();
	
}
