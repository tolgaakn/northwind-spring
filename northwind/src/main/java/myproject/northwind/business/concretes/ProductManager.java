package myproject.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.northwind.business.abstracts.ProductService;
import myproject.northwind.dataAccess.abstracts.ProductDao;
import myproject.northwind.entities.concretes.Product;

@Service //Bu class projede servis görevi görecek.
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired //ProductDao'nun instance'ı olacak class üretir.
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		return this.productDao.findAll();
	}

}
