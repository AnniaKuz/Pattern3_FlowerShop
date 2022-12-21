package commands;

import data_input.DataInput;
import data_sources.ProductDataSource;
import entities.*;
import factories.ProductAbstractFactory;
import factories.ProductProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddProductCommand implements Command{
    ProductDataSource dataSource;
    DataInput dataInput;
    ProductProvider productProvider;
    FlowerShop flowerShop;
    {
        flowerShop = FlowerShop.getInstance();
    }
    @Override
    public void execute() {
        ProductDTO productDTO = dataInput.getProductForSave();
        ProductType productType = productDTO.getProductType();
        ProductAbstractFactory productAbstractFactory = productProvider.getProductFactory(productType);
        Integer productId = dataSource.add(productDTO);
        Product product = productAbstractFactory.create(productId,productDTO.getInfo(),productDTO.getPrice());
        flowerShop.addProduct(product,productType);

        System.out.println("Successfully added!");
    }
}
