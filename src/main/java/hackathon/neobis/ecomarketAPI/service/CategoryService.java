package hackathon.neobis.ecomarketAPI.service;

import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.repo.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	private CategoryRepository categoryRepo;

	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	public void populate() {
		//FOR TEST PURPOSES: HARD-CODING CATEGORIES
		categoryRepo.save(new Category("Фрукты","Картинка Фруктов"));
		categoryRepo.save(new Category("Сухофрукты", "Картинка Сухофруктов"));
		categoryRepo.save(new Category("Овощи","Картинка Овощей"));
		categoryRepo.save(new Category("Зелень","Картинка Зелени"));
		categoryRepo.save(new Category("Чай кофе","Картинка Чай кофе"));
		categoryRepo.save(new Category("Молочные продукты","Картинка Молочных продуктов"));
	}

	public List<Category> getAll() {
		return categoryRepo.findAll();
	}

	public Optional<Category> getFromName(String name) {
		return categoryRepo.findByName(name);
	}
}
