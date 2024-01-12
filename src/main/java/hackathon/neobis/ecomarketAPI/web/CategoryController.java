package hackathon.neobis.ecomarketAPI.web;

import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.model.Picture;
import hackathon.neobis.ecomarketAPI.repo.CategoryRepository;
import hackathon.neobis.ecomarketAPI.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

	private CategoryService service;

	public CategoryController(CategoryService service) {
		this.service = service;
	}

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return service.getAll();
	}
}
