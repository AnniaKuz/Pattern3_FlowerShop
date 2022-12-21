package commands;

import data_sources.ProductDataSource;

import data_sources.TicketDataSource;
import entities.*;
import factories.ProductAbstractFactory;
import factories.ProductProvider;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


@Data
public class InitShopCommand implements Command{
    Scanner scan;
    ProductDataSource dataSource;
    TicketDataSource ticketDataSource;
    ProductProvider productProvider;
    FlowerShop flowerShop;
    Ticket ticket;
    {
        flowerShop = FlowerShop.getInstance();
        ticket = Ticket.getInstance();
    }

    @Override
    public void execute() {
        List<ProductDTO> products = dataSource.getAll();
        //Map<Integer, List<Integer>> tickets = ticketDataSource.getAll();
       products.forEach(p->{
           ProductType productType = p.getProductType();
           ProductAbstractFactory productAbstractFactory = productProvider.getProductFactory(productType);
           Product product = productAbstractFactory.create(p.getId(),p.getInfo(),p.getPrice());
            flowerShop.addProduct(product,productType);

       });
        System.out.println(flowerShop.getProducts().size());
        System.out.println("You can start working with your shop");
    }
}
