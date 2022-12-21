package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor

@Data
public class Invoice {
    Integer id;
    List<Product> products;
    int totalProducts;
    double totalPrice;

    public Invoice(List<Product> products, int totalProducts, double totalPrice) {
        this.products = products;
        this.totalProducts = totalProducts;
        this.totalPrice = totalPrice;
    }

    public Invoice(Integer id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    //1-1,2,3,4
     Ticket ticket;
    {
        products = new ArrayList<>();
       ticket =  Ticket.getInstance();
        }

    public void addProduct(Product product){
        products.add(product);
    }
    public void confirmInvoice(){
        ticket.addInvoice(this);

    }

    //???
    public double calculateInvoice(){
    double total = 0;
    if(!products.isEmpty()){
        for(int i = 0; i<=products.size();i++){
            total = products.get(i).getPrice()+ total;
        }
    }else{
        System.out.println("ProductList is empty");
    }
    return total;
    }


    }

