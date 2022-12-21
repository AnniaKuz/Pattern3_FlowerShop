package factories;

/*public interface Product {
    String toString();
}*/


import entities.Product;
import entities.Tree;

class TreeFactory implements ProductAbstractFactory {
    public Product create(Integer id,Object productInfo, double price) {

        return (Product) new Tree(id,Double.parseDouble((String)productInfo), price);
    }
}

