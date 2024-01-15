package hackathon.neobis.ecomarketAPI.service;

import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.repo.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	private CategoryRepository categoryRepo;

	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	public void populate() throws IOException {
		//FOR TEST PURPOSES: HARD-CODING CATEGORIES
		File temp = new File("src/main/resources/placeholder.png");
		MultipartFile tempImage = new MockMultipartFile(
				"test", new FileInputStream(temp)
		);
		categoryRepo.save(new Category("Фрукты",tempImage));
		categoryRepo.save(new Category("Сухофрукты", tempImage));
		categoryRepo.save(new Category("Овощи",tempImage));
		categoryRepo.save(new Category("Зелень",tempImage));
		categoryRepo.save(new Category("Чай кофе",tempImage));
		categoryRepo.save(new Category("Молочные продукты",tempImage));
	}

	public List<Category> getAll() {
		return categoryRepo.findAll();
	}

	public Optional<Category> getFromName(String name) {
		return categoryRepo.findByName(name);
	}
}
