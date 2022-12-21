package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class FlowerShop {
    private  static  FlowerShop instance;
    private String name;
    List<Product> products;


    {
        products = new ArrayList<>();

    }

    public void getAllProducts(){
        System.out.println(products);
    }

    public void addProduct(Object product, ProductType productType){
        switch(productType) {
            case FLOWER:
                products.add((Flower) product);
                break;
            case DECO:
                products.add((Deco) product);
                break;
            case TREE:
                products.add((Tree) product);
                break;
        }
    }

    public void removeProduct(Integer id){
        if(!products.isEmpty()) {
           Iterator<Product> iter = products.iterator();
           while(iter.hasNext()) {
               Product p = iter.next();
               if(p.getId().equals(id)){
                   products.remove(p);
               }
           }
        }
    }


    public double calculateTotal(){
        double total = 0.0;
        if(!products.isEmpty()) {
            total=products.stream().filter(product ->product!=null&&
                            (Double)product.getPrice()!=null).mapToDouble(Product::getPrice).sum();
        }
        return total;
    }


    public static FlowerShop getInstance(){
        if(instance==null){
            instance = new FlowerShop();
        }
        return instance;
    }

}
