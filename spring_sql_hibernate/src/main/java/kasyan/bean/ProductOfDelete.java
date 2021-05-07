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
public class ProductOfDelete {
    @Id
    private int id;
    @Column(name="category")
    private String category;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="discount")
    private double discount;
    @Column(name="actualPrice")
    private double actualPrice;
    @Column(name="totalVolume")
    private double totalVolume;
    @Column(name="data")
    private String data;
}
