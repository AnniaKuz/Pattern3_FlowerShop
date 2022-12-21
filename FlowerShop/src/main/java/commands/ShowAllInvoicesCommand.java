package commands;

import data_sources.file.TicketData;
import entities.FlowerShop;
import entities.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ShowAllInvoicesCommand implements Command{

    TicketData ticketData;
    FlowerShop flowerShop;
    {
        flowerShop = FlowerShop.getInstance();
    }

    private static final String FILE_PATH = "product_storage/ticket.txt";
    private static Path path = Paths.get(FILE_PATH);

    @Override
    public void execute() throws IOException {

        List<Invoice> ticket= ticketData.getAll();

        ticket.forEach(x->
                System.out.println("Id:"+x.getId()+"; number products: "+x.getTotalProducts()+"; total price: "+ x.getTotalPrice()));
    }
}
