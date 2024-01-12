package hackathon.neobis.ecomarketAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long categoryId;

	private String name;

	private String picture;

	@OneToMany(
			mappedBy = "category"
	)
	@JsonBackReference
	private List<Product> products;

	public Category(String name, String picture) {
		this.name = name;
		this.picture = picture;
	}

	public Category() {
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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
}
