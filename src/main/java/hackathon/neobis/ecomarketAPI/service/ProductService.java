package hackathon.neobis.ecomarketAPI.service;

import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.model.Product;
import hackathon.neobis.ecomarketAPI.repo.CategoryRepository;
import hackathon.neobis.ecomarketAPI.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

	private ProductRepository productRepo;

	private CategoryService categoryService;


	public ProductService(ProductRepository productRepo, CategoryService categoryService) {
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
	public void populate(){
		categoryService.populate();
		productRepo.save(new Product(
						"Яблоко",
						"картинка яблока",
						20,
						categoryService.getFromName("Фрукты").orElse(new Category("Неизвестно", "Неизвестно"))
				)
		);
		productRepo.save(new Product(
						"Апельсин",
						"картинка апельсина",
						30,
						categoryService.getFromName("Фрукты").orElse(new Category("Неизвестно", "Неизвестно"))
				)
		);
		productRepo.save(new Product(
						"Молоко",
						"картинка молока",
						100,
						categoryService.getFromName("Молочные продукты").orElse(new Category("Неизвестно", "Неизвестно"))
				)
		);
		productRepo.save(new Product(
						"Йогурт",
						"картинка йогурта",
						150,
						categoryService.getFromName("Молочные продукты").orElse(new Category("Неизвестно", "Неизвестно"))
				)
		);
	}

	public Product getProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
}
