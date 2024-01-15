package hackathon.neobis.ecomarketAPI.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long productId;

	private String name;

	private int price;

	private byte[] data;

	private String contentType;

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
			MultipartFile image
	) throws IOException {
		this.name = name;
		this.price = price;
		this.category = category;
		this.data = image.getBytes();
		this.fileName = image.getName();
		this.contentType = image.getContentType();
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

	public Product() {
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
