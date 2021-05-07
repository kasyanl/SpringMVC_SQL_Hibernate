package kasyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private double actualPrice;
    private double totalPrice;
    private double quantity;
}
