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
    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private double price;
    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private double discount;
    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private double actualPrice;
    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private double totalVolume;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date data;

}