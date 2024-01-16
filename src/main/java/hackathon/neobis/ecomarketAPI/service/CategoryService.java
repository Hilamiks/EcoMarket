package hackathon.neobis.ecomarketAPI.service;

import hackathon.neobis.ecomarketAPI.EcoMarketApiApplication;
import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.repo.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepo;

	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	public List<Category> getAll() {
		return categoryRepo.findAll();
	}

	public Optional<Category> getFromName(String name) {
		return categoryRepo.findByName(name);
	}

	public void clear() {
		categoryRepo.deleteAll();
	}

	public Category save(Category category) {
		categoryRepo.save(category);
		return category;
	}

	public Category getById(Long categoryId) {

		return categoryRepo.findById(categoryId).orElse(null);
	}

	public Category delete(Long id) {
		Category category = getById(id);

		String address = EcoMarketApiApplication
				.class
				.getClassLoader()
				.getResource("")
				.toString().replaceFirst("file:","")
				+ category.getName();

		new File(address + ".png").delete();
		new File(address + ".jpg").delete();

		categoryRepo.deleteById(id);
		return category;
	}
}
