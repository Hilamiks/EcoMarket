package hackathon.neobis.ecomarketAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long categoryId;

	private String fileLink;

	private String fileName;

	private String name;

	@OneToMany(
			mappedBy = "category"
	)
	@JsonBackReference
	private List<Product> products;

	public Category(String name, File image) throws IOException {
		this.name = name;
		this.fileName = image.getName();
		this.fileLink = image.getPath();
	}

	public Category() {
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
}
