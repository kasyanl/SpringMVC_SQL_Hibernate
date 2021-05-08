package kasyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOfDelete {
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
