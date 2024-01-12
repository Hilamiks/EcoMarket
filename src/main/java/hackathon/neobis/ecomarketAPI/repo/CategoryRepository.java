package hackathon.neobis.ecomarketAPI.repo;

import hackathon.neobis.ecomarketAPI.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
