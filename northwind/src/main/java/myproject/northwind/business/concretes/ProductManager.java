package myproject.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.northwind.business.abstracts.ProductService;
import myproject.northwind.core.utilities.results.DataResult;
import myproject.northwind.core.utilities.results.Result;
import myproject.northwind.core.utilities.results.SuccessDataResult;
import myproject.northwind.core.utilities.results.SuccessResult;
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
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi.");
	}

}
