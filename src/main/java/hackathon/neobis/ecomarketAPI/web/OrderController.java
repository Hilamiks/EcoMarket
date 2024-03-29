package hackathon.neobis.ecomarketAPI.web;

import hackathon.neobis.ecomarketAPI.model.Order;
import hackathon.neobis.ecomarketAPI.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrderController {


	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/order")
	public Order postOrder(
			@RequestBody Order order
	) {
		order.setCreationDate(LocalDateTime.now());
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

	@DeleteMapping("/clearorders")
	public String clear() {
		orderService.clear();
		return "orders have been cleared";
	}

	@GetMapping("/orders")
	public List<Order> getOrders() {
		return orderService.getAll();
	}
}
