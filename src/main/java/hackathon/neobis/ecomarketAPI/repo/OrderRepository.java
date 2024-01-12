package hackathon.neobis.ecomarketAPI.repo;

import hackathon.neobis.ecomarketAPI.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
