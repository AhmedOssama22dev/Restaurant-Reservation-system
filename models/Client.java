package models;

public class Client extends SystemUser {

    public Client(String name, String username, String password) {
		super(name, "Client", username, password);
		// TODO Auto-generated constructor stub
	}
	
    private Boolean isPremium;
    private Boolean isSmoker;
    private float chequeValue;

    public float getChequeValue() {
        return chequeValue;
    }

    public void setChequeValue(int chequeValue) {
        this.chequeValue = chequeValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public Boolean getSmoker() {
        return isSmoker;
    }

    public void setSmoker(Boolean smoker) {
        isSmoker = smoker;
    }


    void makeReservationOn(Table table){}
    //float order(DishOrder dish, int quantity){ return  chequeValue=quantity*dish.getPrice();}
    void checkOut(int chequeValue){/*Put payment in the data sheet*/}
}
