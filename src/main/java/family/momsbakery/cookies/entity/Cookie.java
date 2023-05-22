package family.momsbakery.cookies.entity;

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
public class Cookie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    public Cookie (String name, int price) {
        this.name = name;
        this.price = price;
    }
}
