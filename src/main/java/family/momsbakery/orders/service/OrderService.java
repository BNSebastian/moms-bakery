package family.momsbakery.orders.service;

import family.momsbakery.orders.entity.Order;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order);

    Order getOrder(Long id);

    List<Order> getOrders();

    void updateOrder(Order order);

    void deleteOrder(Long id);

}
