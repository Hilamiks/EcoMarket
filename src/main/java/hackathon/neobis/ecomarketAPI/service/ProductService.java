package hackathon.neobis.ecomarketAPI.service;

import hackathon.neobis.ecomarketAPI.EcoMarketApiApplication;
import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.model.Product;
import hackathon.neobis.ecomarketAPI.model.ProductDTO;
import hackathon.neobis.ecomarketAPI.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

	private final ProductRepository productRepo;

	private final CategoryService categoryService;

	public ProductService(
			ProductRepository productRepo,
			CategoryService categoryService
	) {
		this.productRepo = productRepo;
		this.categoryService = categoryService;
	}

	public List<Product> getProductByCategoryId(Long categoryID) {
		return productRepo
				.findAll()
				.stream()
				.filter(product -> product.getCategory().getCategoryId().equals(categoryID))
				.collect(Collectors.toList());
	}

	public Product getProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	public Product save(ProductDTO product, File file) {
		Category category = categoryService.getById(product.getCategoryId());
		Product trueProduct = product.convert(file, category);
		return productRepo.save(trueProduct);
	}


	//JUST HARD CODED TESTS

	public void clear() {
		categoryService.clear();
		productRepo.deleteAll();
	}

	public Product delete(Long id) {
		Product product = productRepo.findById(id).orElse(null);
		productRepo.deleteById(id);

		String address = EcoMarketApiApplication
				.class
				.getClassLoader()
				.getResource("")
				.toString().replaceFirst("file:","")
				+ product.getName();

		new File(address + ".png").delete();
		new File(address + ".jpg").delete();

		return product;
	}
}
