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

	private OrderRepository orderRepo;

	private ProductService productService;

	public OrderService(OrderRepository orderRepo, ProductService productService) {
		this.orderRepo = orderRepo;
		this.productService = productService;
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

	public void populate() {
		orderRepo.save(
				new Order(
						"+123 456 789",
						"123 Random St",
						"Random house",
						"please, don't be late",
						List.of(
								1l,
								2l
						),
						Status.COMPLETE
				)
		);
		orderRepo.save(
				new Order(
						"+123 456 789",
						"123 Random St",
						"Random house",
						"please, don't be late",
						List.of(
								2l,
								3l
						),
						Status.COMPLETE
				)
		);
		orderRepo.save(
				new Order(
						"+123 456 789",
						"123 Random St",
						"Random house",
						"please, don't be late",
						List.of(
								4l,
								1l
						),
						Status.COMPLETE
				)
		);
		orderRepo.save(
				new Order(
						"+987 654 321",
						"321 Specific St",
						"Specific house",
						"please, don't be late",
						List.of(
								3l,
								1l
						),
						Status.ACTIVE
				)
		);
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
}
