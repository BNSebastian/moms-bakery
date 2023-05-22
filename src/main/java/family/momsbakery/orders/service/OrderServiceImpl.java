package family.momsbakery.orders.service;

import family.momsbakery.orders.entity.Order;
import family.momsbakery.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public void saveOrder(Order order) {
        repository.save(order);
    }

    @Override
    public Order getOrder(Long id) {
        if (repository.findById(id).isPresent()){
            return repository.findById(id).get();
        } else {
            throw new RuntimeException("Did not find " + Order.class.getName() + " with id: " + id);
        }
    }

    @Override
    public List<Order> getOrders() {
        if (!repository.findAll().isEmpty()){
            return repository.findAll();
        } else {
            throw new RuntimeException("Did not find any " + Order.class.getName());
        }
    }

    @Override
    public void updateOrder(Order order) {
        if (repository.findById(order.getId()).isPresent()){
            repository.save(order);
        } else {
            throw new RuntimeException("Did not find " + Order.class.getName() + " with id: " + order.getId());
        }
    }

    @Override
    public void deleteOrder(Long id) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Did not find " + Order.class.getName() + " with id: " + id);
        }
    }
}
