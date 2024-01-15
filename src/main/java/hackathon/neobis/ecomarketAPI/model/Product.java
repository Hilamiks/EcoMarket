package hackathon.neobis.ecomarketAPI.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.File;
import java.io.IOException;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long productId;

	private String name;

	private String description;

	private int price;

	private String fileLink;

	private String fileName;

	@ManyToOne
	@JoinColumn(
			name = "category_id"
	)
	@JsonManagedReference
	private Category category;

	public Product(
			String name,
			int price,
			Category category,
			String description,
			File image
	) throws IOException {
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
		this.fileName = image.getName();
		this.fileLink = image.getPath();
	}


	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Product() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
