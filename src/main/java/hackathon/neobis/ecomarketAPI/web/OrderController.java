package hackathon.neobis.ecomarketAPI.web;

import hackathon.neobis.ecomarketAPI.model.Order;
import hackathon.neobis.ecomarketAPI.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {


	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/order")
	public Order postOrder(
			@RequestBody Order order
	) {
		orderService.save(order);
		return order;
	}

	//JUST FOR TESTS
	@GetMapping("/populateorders")
	public String populating() {
		orderService.populate();
		return "Orders created for tests";
	}

	@GetMapping("/orders")
	public List<Order> getOrders() {
		return orderService.getAll();
	}
}
