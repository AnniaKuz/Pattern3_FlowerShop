package commands;

import entities.FlowerShop;

import java.io.IOException;

public class GetTotalValueCommand implements Command{
    FlowerShop flowerShop;
    {
        flowerShop = FlowerShop.getInstance();
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Total value is " +flowerShop.calculateTotal());
    }
}
