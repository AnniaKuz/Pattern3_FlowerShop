package commands;

import data_input.DataInput;
import data_sources.file.ProductData;
import data_sources.file.TicketData;
import entities.*;
import lombok.Data;

import java.util.List;

@Data
public class AddTicketCommand implements Command{

  DataInput dataInput;
  ProductData productData;
  TicketData ticketData;
  FlowerShop flowerShop;
    {
        flowerShop = FlowerShop.getInstance();
    }
    @Override
    public void execute() {
        List<Integer> listId = dataInput.getInvoice();
       List<Product> invoiceProducts = listId.stream().map(

             id->{
                 for(Product p:flowerShop.getProducts()){
                     if(p.getId().equals(id)){
                         return p;
                     }
                 }
               return null;
             }


       ).toList();
       int totalNumber = invoiceProducts.size();
       double totalPrice  = invoiceProducts.stream().reduce(0.0,(x,y)->x+y.getPrice(),Double::sum);
Invoice invoice = new Invoice(invoiceProducts,totalNumber,totalPrice);
Integer invoiceId =ticketData.addInvoice(invoice);
invoice.setId(invoiceId);
       invoice.confirmInvoice();

       for(int i = 0; i<invoiceProducts.size();i++){
           int id = invoiceProducts.get(i).getId();
           productData.remove(id);
       }

    }
}
