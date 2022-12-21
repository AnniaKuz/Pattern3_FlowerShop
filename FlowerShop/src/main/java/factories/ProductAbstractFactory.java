package factories;




import entities.Product;

public interface ProductAbstractFactory {
    Product create(Integer id, Object productInfo, double price);

}


