package hackathon.neobis.ecomarketAPI.web;

import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.model.Picture;
import hackathon.neobis.ecomarketAPI.repo.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

	private CategoryRepository repo;

	public CategoryController(CategoryRepository repo) {
		this.repo = repo;
		//FOR TEST PURPOSES: HARD-CODING CATEGORIES
		repo.save(new Category("Фрукты","Картинка Фруктов"));
		repo.save(new Category("Сухофрукты", "Картинка Сухофруктов"));
		repo.save(new Category("Овощи","Картинка Овощей"));
		repo.save(new Category("Зелень","Картинка Зелени"));
		repo.save(new Category("Чай кофе","Картинка Чай кофе"));
		repo.save(new Category("Молочные продукты","Картинка Молочных продуктов"));
	}

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return repo.findAll();
	}
}
