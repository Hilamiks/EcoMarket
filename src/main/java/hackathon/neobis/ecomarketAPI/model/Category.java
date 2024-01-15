package hackathon.neobis.ecomarketAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long categoryId;

	private byte[] data;

	private String contentType;

	private String fileName;

	private String name;

	@OneToMany(
			mappedBy = "category"
	)
	@JsonBackReference
	private List<Product> products;

	public Category(String name, MultipartFile image) throws IOException {
		this.name = name;
		this.data = image.getBytes();
		this.fileName = image.getName();
		this.contentType = image.getContentType();
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
