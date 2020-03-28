package models;

public class DishOrder {
	private  Float price; //will be set from the parser


    public float getPrice() {
        return price;
    }
    /*
    * type appetizer will given 0,main course 1 , dessert 2
    * */
    public void setPriceAfterTax(int type,float price) {
//        switch (type)
//        {
//            case 0:this.price=price+(price*appetizerTax);
//            case 1:this.price=price+(price*mainCourseTax);
//            case 2:this.price=price+(price*dessertTax);
//        }
    }
}
