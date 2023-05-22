package family.momsbakery.orders.repository;

import family.momsbakery.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // TODO - define extra queries
}
