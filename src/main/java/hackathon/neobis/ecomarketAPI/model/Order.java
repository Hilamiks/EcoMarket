package hackathon.neobis.ecomarketAPI.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchases")
public class Order {

	@Id
	@GeneratedValue
	private Long orderId;

	private String phoneNumber;

	private LocalDateTime creationDate;

	private String address;

	private String referenceLocation;

	private String comment;

	private List<Long> products;

	private Status status;

	public Order(
			String phoneNumber,
			String address,
			String referenceLocation,
			String comment,
			List<Long> products,
			Status status) {
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.referenceLocation = referenceLocation;
		this.comment = comment;
		this.products = products;
		this.status = status;
		this.creationDate = LocalDateTime.now();
	}

	public Order() {
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReferenceLocation() {
		return referenceLocation;
	}

	public void setReferenceLocation(String referenceLocation) {
		this.referenceLocation = referenceLocation;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Long> getProducts() {
		return products;
	}

	public void setProducts(List<Long> products) {
		this.products = products;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
