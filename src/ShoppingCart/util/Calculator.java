package ShoppingCart.util;

public class Calculator {

    public static int getDeliveryCharge(double weight, int price) {

        int baseDeliveryCharge = getBaseDeliveryCharge(weight);

        if (price < 30000) {
            return baseDeliveryCharge;
        } else if (price >= 30000 && price < 100000) {
            baseDeliveryCharge -= 1000;
            return baseDeliveryCharge;
        }else{
            baseDeliveryCharge=0;
            return baseDeliveryCharge;
        }
    }

    private static int getBaseDeliveryCharge(double weight){
        int deliveryCharge;

        if (weight <3.0){
            deliveryCharge = 1000;
            return deliveryCharge;
        }else if(weight>=3.0&&weight<10.0){
            deliveryCharge = 5000;
            return deliveryCharge;
        }else{
            deliveryCharge  = 10000;
            return deliveryCharge;
        }
    }
}
