package hackathon.neobis.ecomarketAPI.model;

import java.io.File;

public class ProductDTO {

	private String name;

	private String description;

	private int price;

	private Long categoryId;

	public ProductDTO(String name, String description, int price, Long categoryId) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.categoryId = categoryId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product convert(File file, Category category) {

		Product product = new Product();

		product.setDescription(this.getDescription());
		product.setFileLink(file.getPath());
		product.setCategory(category);
		product.setPrice(this.getPrice());
		product.setFileName(file.getName());
		product.setName(this.getName());

		return product;

	}
}
