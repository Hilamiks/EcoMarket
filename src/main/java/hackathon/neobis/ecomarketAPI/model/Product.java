package hackathon.neobis.ecomarketAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long productId;

	private String name;

	private String picture;

	private int price;

	@ManyToOne
	@JoinColumn(
			name = "category_id"
	)
	@JsonBackReference
	private Category category;

	public Product(String name, String picture, int price, Category category) {
		this.name = name;
		this.picture = picture;
		this.price = price;
		this.category = category;
	}

	public Product() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
