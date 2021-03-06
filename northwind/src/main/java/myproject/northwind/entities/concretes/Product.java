package myproject.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Lombok aracılığıyla getter ve setterları oluşturur.
@Entity
@Table(name = "products") //Nesnenin veritabanında hangi tabloya karşılık geldiğini belirtiyor.
@AllArgsConstructor //Lombok
@NoArgsConstructor  //Lombok
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Id alanının nasıl üretildiğini tanımlamak için kullanılır. GeneratedValue 1, 1 artıyor.
	@Column(name="product_id") //Alanlarla, veritabanındaki kolonları eşitlemek için kullanılıyor.
	private int id;
	
	//@Column(name="category_id") //Aşağıda ManyToOne yaptığımız için category_id'yi burada tutmamıza gerek yok.
	//private int categoryId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
}
