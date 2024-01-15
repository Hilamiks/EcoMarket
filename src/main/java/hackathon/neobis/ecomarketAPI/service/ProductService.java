package hackathon.neobis.ecomarketAPI.service;

import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.model.Order;
import hackathon.neobis.ecomarketAPI.model.Product;
import hackathon.neobis.ecomarketAPI.repo.CategoryRepository;
import hackathon.neobis.ecomarketAPI.repo.ProductRepository;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

	private ProductRepository productRepo;

	private CategoryService categoryService;

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

	//JUST HARD CODED TESTS
	public void populate() throws IOException {
		categoryService.populate();
		File temp = new File("src/main/resources/apple.png");
		MultipartFile tempImage = new MockMultipartFile(
				"test", new FileInputStream(temp)
		);
		productRepo.save(new Product(
						"Яблоко",
						20,
						categoryService.getFromName("Фрукты").orElse(null),
						tempImage
				)
		);
		productRepo.save(new Product(
						"Апельсин",
						30,
						categoryService.getFromName("Фрукты").orElse(null),
						tempImage
				)
		);
		productRepo.save(new Product(
						"Молоко",
						100,
						categoryService.getFromName("Молочные продукты").orElse(null),
						tempImage
				)
		);
		productRepo.save(new Product(
						"Йогурт",
						150,
						categoryService.getFromName("Молочные продукты").orElse(null),
						tempImage
				)
		);
	}

	public Product getProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}

}
