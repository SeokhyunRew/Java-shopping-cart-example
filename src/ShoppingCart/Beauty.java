package ShoppingCart;

public class Beauty extends Product{

    public  Beauty(String name, int price, double weight) {
        super(name, price, weight);
    }

    public int getPrice(){
        return price;
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public int getDiscountAmount(){
        return 10000;
    }
}
