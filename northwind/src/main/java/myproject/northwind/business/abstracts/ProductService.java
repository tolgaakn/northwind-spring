package myproject.northwind.business.abstracts;

import java.util.List;

import myproject.northwind.core.utilities.results.DataResult;
import myproject.northwind.core.utilities.results.Result;
import myproject.northwind.entities.concretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
}
