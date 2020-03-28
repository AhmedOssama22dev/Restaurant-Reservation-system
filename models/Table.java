package models;

public class Table {
	public Integer tableNumber;
	public Integer seatsCount;
	public Boolean isSmoking;	

	public Table(Integer tableNumber, Integer seatsCount, Boolean isSmoking) {
		super();
		this.tableNumber = tableNumber;
		this.seatsCount = seatsCount;
		this.isSmoking = isSmoking;
	}
	
	@Override
	public String toString() {
		return "Table [tableNumber=" + tableNumber + ", seatsCount=" + seatsCount + ", isSmoking=" + isSmoking + "]";
	}
}
