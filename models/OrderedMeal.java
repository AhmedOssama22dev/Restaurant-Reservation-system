package models;

public class OrderedMeal {

	public String clientName = "";
	public DishCategory dishCategory = DishCategory.MAIN_COURSE;
	public String dishName;
	public Integer tableNumber = 0;
	
	public OrderedMeal(String clientName, DishCategory dishCategory, String dishName, Integer tableNumber) {
		super();
		this.clientName = clientName;
		this.dishCategory = dishCategory;
		this.dishName = dishName;
		this.tableNumber = tableNumber;
	}

	public Integer getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getClientName() {
		return clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public DishCategory getDishCategory() {
		return dishCategory;
	}
	
	public void setDishCategory(DishCategory dishCategory) {
		this.dishCategory = dishCategory;
	}
	
	public String getDishName() {
		return dishName;
	}
	
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
}
