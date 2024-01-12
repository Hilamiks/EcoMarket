package hackathon.neobis.ecomarketAPI.repo;

import hackathon.neobis.ecomarketAPI.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Optional<Category> findByName(String name);

}
