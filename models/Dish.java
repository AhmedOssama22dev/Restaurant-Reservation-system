package models;


public class Dish {
	
	public String name;
	public Integer price;
	private DishCategory category;
	
	public DishCategory getCategory() {
		return category;
	}
	
	public void setCategory(DishCategory category) {
		this.category = category;
	}
	
	public Dish(String name, Integer price, String category) {
		super();
		this.name = name;
		this.price = price;
		
		switch (category) {
		case "main_course":
			this.category = DishCategory.MAIN_COURSE;
			break;
		case "desert":
			this.category = DishCategory.DESSERT;
			break;
		case "appetizer":
			this.category = DishCategory.APPETIZER;
			break;
		}
	}
        public Dish() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", price=" + price + ", category=" + category + "]";
	}
	
}
