package hackathon.neobis.ecomarketAPI.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "purchases")
public class Order {

	@Id
	@GeneratedValue
	private long orderId;

	private String phoneNumber;

	private String address;

	private String referenceLocation;

	private String comment;

	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	@JoinTable(
			name = "ORDER_PRODUCT",
			joinColumns = {
					@JoinColumn(
							name = "order_id",
							referencedColumnName = "orderId"
					)
			},
			inverseJoinColumns = {
					@JoinColumn(
							name = "product_id",
							referencedColumnName = "productId"
					)
			}
	)
	private List<Product> products;

	private Status status;

	public Order(String phoneNumber, String address, String referenceLocation, String comment, List<Product> products, Status status) {
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.referenceLocation = referenceLocation;
		this.comment = comment;
		this.products = products;
		this.status = status;
	}

	public Order() {
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
