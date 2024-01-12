package hackathon.neobis.ecomarketAPI.web;

import hackathon.neobis.ecomarketAPI.model.Order;
import hackathon.neobis.ecomarketAPI.model.Product;
import hackathon.neobis.ecomarketAPI.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping("products/{categoryID}")
	public List<Product> getProducts(@PathVariable Long categoryID) {
		return service.getProductByCategoryId(categoryID);
	}

	@GetMapping("products/info/{productId}")
	public Product getProduct(@PathVariable Long productId) {
		return service.getProductById(productId);
	}


	//TEST PURPOSES ONLY
	@GetMapping("/populate")
	public String populate() {
		service.populate();
		return "populated";
	}
}
