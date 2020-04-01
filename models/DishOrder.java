package models;

public class DishOrder extends Dish{
	private  Float price; //will be set from the parser


    public void setPrice(Float price) {
		this.price = price;
	}
	public Float getPrice() {
        return price;
    }


	
	public DishOrder() {
		super();
	}
	public Float setPriceAfterTax ( int typeIndex, Integer nDishes,final Float tax) {
    	Integer totalPriceBeforeTax=Restaurant.mainRestaurant.dishes.get(typeIndex).price*nDishes;
		setPrice(totalPriceBeforeTax +tax*totalPriceBeforeTax);
		return getPrice();
	}
}
