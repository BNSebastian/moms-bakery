package family.momsbakery.orders.controller;

import family.momsbakery.orders.entity.Order;
import family.momsbakery.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService service;

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return service.getOrders();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable Long id) {
        return service.getOrder(id);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/orders")
    public void addOrder(@RequestBody Order order) {
        service.saveOrder(order);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @PutMapping("/orders")
    public void updateOrder(@RequestBody Order order) {
        service.saveOrder(order);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }

}
