package myproject.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> { //Integer alanı, primary key türünü tanımlar.
//JpaRepository içerisine tanımlanan entity için CRUD operasyonlarını sağlar.
	
}
