package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProductDTO {
    Integer id;
    ProductType productType;
    Object info;
    double price;

    public ProductDTO(ProductType productType, Object info, double price) {
        this.productType = productType;
        this.info = info;
        this.price = price;
    }
}
