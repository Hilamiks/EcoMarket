package hackathon.neobis.ecomarketAPI.repo;


import hackathon.neobis.ecomarketAPI.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByPhoneNumber(String number);

}
