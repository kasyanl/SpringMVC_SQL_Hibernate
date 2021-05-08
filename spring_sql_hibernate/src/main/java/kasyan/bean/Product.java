package kasyan.bean;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private int id;
    private String category;
    private String name;
    private double price;
    private double discount;
    private double actualPrice;
    private double totalVolume;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date data;

}