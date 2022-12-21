package main;
/*
I simplified the menu by putting addProducts commands and removeProduct commands in two because
this way it will be easier to add a new productType in the future.

I could have read file.txt in the beginning and rewrite it in the end, but in my opinion it is better to work
in real time.

There is an option for the program to switch to another way of input information. Right now it s a Scanner,
but usually programs get the information from another sources.

Here I work with txt files but I made the initial base to connect to some DB.
 */

import commands.*;
import data_input.data_input_console.InputDataFromConsole;
import data_sources.file.ProductData;
import data_sources.file.TicketData;
import entities.FlowerShop;
import factories.ProductProvider;
import java.util.Scanner;


public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        SwitchCommand switchCommand = new SwitchCommand();
        InitShopCommand initShopCommand = new InitShopCommand();
        initShopCommand.setDataSource(new ProductData());
        initShopCommand.setProductProvider(new ProductProvider());
        switchCommand.registerCommand("1",initShopCommand);

        AddProductCommand addProductCommand = new AddProductCommand();
        addProductCommand.setDataSource(new ProductData());
        addProductCommand.setDataInput(new InputDataFromConsole(scan));
        addProductCommand.setProductProvider(new ProductProvider());
        switchCommand.registerCommand("2",addProductCommand);

        RemoveProductCommand removeProductCommand = new RemoveProductCommand();
        removeProductCommand.setDataSource(new ProductData());
        removeProductCommand.setDataInput(new InputDataFromConsole(scan));
        switchCommand.registerCommand("3",removeProductCommand);

        ShowProductsCommand showNumberProductsCommand = new ShowProductsCommand();
        showNumberProductsCommand.setDataSource(new ProductData());
        switchCommand.registerCommand("4", showNumberProductsCommand);

        GetQuantityOfEachCommand getQuantityOfEach = new GetQuantityOfEachCommand();
        getQuantityOfEach.setDataSource(new ProductData());
        getQuantityOfEach.setProductProvider(new ProductProvider());
        switchCommand.registerCommand("5",getQuantityOfEach);

        GetTotalValueCommand getTotalValue = new GetTotalValueCommand();
        switchCommand.registerCommand("6", getTotalValue);

        AddTicketCommand addTicketCommand = new AddTicketCommand();
        addTicketCommand.setDataInput(new InputDataFromConsole(scan));
        addTicketCommand.setTicketData(new TicketData());
        addTicketCommand.setProductData(new ProductData());
        switchCommand.registerCommand("7",addTicketCommand);

        ShowAllInvoicesCommand showAllInvoices = new ShowAllInvoicesCommand();
        showAllInvoices.setTicketData(new TicketData());
        switchCommand.registerCommand("8", showAllInvoices);


        ShowAllEarningsCommand showAllEarnings = new ShowAllEarningsCommand();
        showAllEarnings.setTicketData(new TicketData());
        showAllEarnings.setProductData(new ProductData());
        switchCommand.registerCommand("9", showAllEarnings);


        String option = null;
        writeName(new FlowerShop());
        System.out.println("Do 1.Create a flower shop, first!");
        do{
            System.out.println("Choose an option: \n"
                    + "1.Create a flower shop \n"
                    + "2.Add product \n"
                    + "3.Remove a product\n"
                    + "4.Show all the products\n"
                    + "5.Show stock quantity of each product\n"
                    + "6.Show total value of a flower shop\n"
                    + "7.Create a new ticket with multiple products\n"
                    + "8.Show all the purchase\n"
                    + "9.Show all the earnings\n"
                    + "0.Exit");
            option = scan.next();
            switchCommand.execute(option);

        }while(Integer.parseInt(option) != 0);

    }

    public static void writeName(FlowerShop flowerShop){
        System.out.println("Write a name for the flowerShop");
        flowerShop.setName(scan.next());
    }
}