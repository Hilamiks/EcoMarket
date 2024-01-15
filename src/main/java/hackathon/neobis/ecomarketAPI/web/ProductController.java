package hackathon.neobis.ecomarketAPI.web;

import hackathon.neobis.ecomarketAPI.EcoMarketApiApplication;
import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.model.Product;
import hackathon.neobis.ecomarketAPI.model.ProductDTO;
import hackathon.neobis.ecomarketAPI.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

	@PostMapping("/new/product")
	public Product createProduct(
			@RequestPart("image") MultipartFile file,
			@RequestParam String name,
			@RequestParam String description,
			@RequestParam int price,
			@RequestParam Long categoryId) throws IOException {

		ProductDTO product = new ProductDTO(name, description, price, categoryId);

		String extension;

		if (file.getContentType().contains("png")) {
			extension = ".png";
		} else {
			extension = ".jpg";
		}

		String address = EcoMarketApiApplication.class.getClassLoader().getResource("").toString() + product.getName() + extension;

		address = address.replaceFirst("file:","");

		System.out.println(address);

		File image = new File(address);

		image.createNewFile();

		file.transferTo(image);

		return service.save(product, image);
	}



		//TEST PURPOSES ONLY
	@DeleteMapping("/clear")
	public String clear() {
		service.clear();
		return "cleared";
	}
}
