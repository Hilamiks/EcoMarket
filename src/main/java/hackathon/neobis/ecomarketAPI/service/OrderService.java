package hackathon.neobis.ecomarketAPI.service;

import hackathon.neobis.ecomarketAPI.model.Order;
import hackathon.neobis.ecomarketAPI.model.Status;
import hackathon.neobis.ecomarketAPI.repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

	private final OrderRepository orderRepo;

	public OrderService(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}

	public Order save(Order order){
		return orderRepo.save(order);
	}

	public List<Order> getAll() {
		return orderRepo.findAll();
	}

	public Optional<Order> getLastOrder(String phone) {
		return orderRepo.findByPhoneNumber(phone)
				.stream()
				.max(
						Comparator.comparing(Order::getCreationDate)
				);
	}

	public List<Order> getHistory(String phone) {
		List<Order> list = orderRepo.findByPhoneNumber(phone);
		list.sort(Comparator.comparing(Order::getCreationDate));
		return list;
	}

	public Order getById(Long id) {
		return orderRepo.findById(id).orElse(null);
	}

	public void clear() {
		orderRepo.deleteAll();
	}
}
