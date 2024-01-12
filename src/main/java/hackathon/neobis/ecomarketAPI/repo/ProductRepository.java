package hackathon.neobis.ecomarketAPI.repo;

import hackathon.neobis.ecomarketAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
