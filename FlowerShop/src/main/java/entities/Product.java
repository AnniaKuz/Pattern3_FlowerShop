package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public abstract class Product{
    public Product(double price) {
        this.price = price;
    }

    Integer id;
    double price;
}
