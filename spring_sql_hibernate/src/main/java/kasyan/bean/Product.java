package kasyan.bean;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private String data;
    private double totalPrice;
    private double quantity;

    public Product(int id, String category, String name, double price, double discount, double actualPrice, double totalVolume, String data) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.actualPrice = actualPrice;
        this.totalVolume = totalVolume;
        this.data = data;
    }

    public Product(int id, String name, double actualPrice, double totalPrice, double quantity) {
        this.id = id;
        this.name = name;
        this.actualPrice = actualPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
}