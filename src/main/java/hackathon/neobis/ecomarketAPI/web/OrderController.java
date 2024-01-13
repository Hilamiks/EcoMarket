package hackathon.neobis.ecomarketAPI.web;

import hackathon.neobis.ecomarketAPI.model.Order;
import hackathon.neobis.ecomarketAPI.service.OrderService;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/order/{phone}")
	public Long getLastOrder(@PathVariable String phone){
		Order x = orderService.getLastOrder(phone).orElse(null);
		if (x == null) {
			return null;
		}
		else {
			return x.getOrderId();
		}
	}

	@GetMapping("/order/info/{id}")
	public Order getInfo(@PathVariable Long id) {
		return orderService.getById(id);
	}

	@GetMapping("/history/{phone}")
	public List<Order> getHistory(@PathVariable String phone) {
		return orderService.getHistory(phone);
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
