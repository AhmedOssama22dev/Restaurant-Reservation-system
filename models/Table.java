package models;

import java.util.*;

public class Table {
	public Integer tableNumber;
	public Integer seatsCount;
	public Boolean isSmoking;	
	public Boolean isReserved;
	private ArrayList<OrderedMeal> orderedMeals;

	public Integer getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Integer getSeatsCount() {
		return seatsCount;
	}

	public void setSeatsCount(Integer seatsCount) {
		this.seatsCount = seatsCount;
	}

	public Boolean getIsSmoking() {
		return isSmoking;
	}

	public void setIsSmoking(Boolean isSmoking) {
		this.isSmoking = isSmoking;
	}

	public Boolean getIsReserved() {
		return isReserved;
	}

	public void setIsReserved(Boolean isReserved) {
		this.isReserved = isReserved;
	}

	public ArrayList<OrderedMeal> getOrderedMeals() {
		return orderedMeals;
	}

	public void setOrderedMeals(ArrayList<OrderedMeal> orderedMeals) {
		this.orderedMeals = orderedMeals;
	}

	public Table(Integer tableNumber, Integer seatsCount, Boolean isSmoking,Boolean isReserved) {
		super();
		setTableNumber(tableNumber);
		setSeatsCount(seatsCount);
		setIsSmoking(isSmoking);
		setIsReserved(isReserved);
		
	}
	
	public Table(Integer tableNumber, Integer seatsCount, Boolean isSmoking, Boolean isReserved,
			ArrayList<OrderedMeal> orderedMeals) {
		super();
		this.tableNumber = tableNumber;
		this.seatsCount = seatsCount;
		this.isSmoking = isSmoking;
		this.isReserved = isReserved;
		this.orderedMeals = orderedMeals;
	}



	@Override
	public String toString() {
		return "Table [tableNumber=" + tableNumber + ", seatsCount=" + seatsCount + ", isSmoking=" + isSmoking
				+ ", isReserved=" + isReserved + ", orderedMeals=" + orderedMeals + "]";
	}

	public boolean isSmoking(boolean isSmoking) {
		// TODO Auto-generated method stub
		return false;
	}
}
