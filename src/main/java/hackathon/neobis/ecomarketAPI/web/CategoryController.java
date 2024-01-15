package hackathon.neobis.ecomarketAPI.web;

import hackathon.neobis.ecomarketAPI.EcoMarketApiApplication;
import hackathon.neobis.ecomarketAPI.model.Category;
import hackathon.neobis.ecomarketAPI.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class CategoryController {

	private final CategoryService service;

	public CategoryController(CategoryService service) {
		this.service = service;
	}

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return service.getAll();
	}

	@PostMapping("/new/category/{name}")
	public Category createCategory(@RequestPart("image") MultipartFile file, @PathVariable String name) throws IOException {

		String extension;

		if (file.getContentType().contains("png")) {
			extension = ".png";
		} else {
			extension = ".jpg";
		}

		String address = EcoMarketApiApplication.class.getClassLoader().getResource("").toString() + name + extension;

		address = address.replaceFirst("file:","");

		System.out.println(address);

		File image = new File(address);

		image.createNewFile();

		file.transferTo(image);

		return service.save(new Category(name, image));
	}

}
