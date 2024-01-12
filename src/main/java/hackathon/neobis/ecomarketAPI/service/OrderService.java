package hackathon.neobis.ecomarketAPI.service;

import hackathon.neobis.ecomarketAPI.model.Order;
import hackathon.neobis.ecomarketAPI.model.Status;
import hackathon.neobis.ecomarketAPI.repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
								productService.getProductById(1L),
								productService.getProductById(2L)
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
								productService.getProductById(2L),
								productService.getProductById(3L)
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
								productService.getProductById(4L),
								productService.getProductById(1L)
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
								productService.getProductById(3L),
								productService.getProductById(1L)
						),
						Status.ACTIVE
				)
		);
	}
}
