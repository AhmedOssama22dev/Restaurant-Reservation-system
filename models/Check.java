package models;

public class Check {
	
	public Integer tableNumber = 0;
	public Integer totalAmount = 0;
	
	public Integer getTableNumber() {
		return tableNumber;
	}
	
	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public Integer getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Check(Integer tableNumber, Integer totalAmount) {
		super();
		this.tableNumber = tableNumber;
		this.totalAmount = totalAmount;
	}
}
