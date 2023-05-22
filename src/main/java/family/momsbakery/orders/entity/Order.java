package family.momsbakery.orders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // used for testing
@Data // getters, setters, toString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cookies")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    public Order(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
