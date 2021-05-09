package kasyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyProduct {
    @Id
    private int id;
    private String name;
    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private double actualPrice;
    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private double totalPrice;
    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private double quantity;
}
