package myproject.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import myproject.northwind.business.abstracts.ProductService;
import myproject.northwind.core.utilities.results.DataResult;
import myproject.northwind.core.utilities.results.Result;
import myproject.northwind.core.utilities.results.SuccessDataResult;
import myproject.northwind.core.utilities.results.SuccessResult;
import myproject.northwind.dataAccess.abstracts.ProductDao;
import myproject.northwind.entities.concretes.Product;
import myproject.northwind.entities.dtos.ProductWithCategoryDto;

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
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort));
	}
	
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public Result add(Product product) {
		
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi.");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data listelendi.");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories), "Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId), "Data listelendi.");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "Data listelendi.");
	}

}
