package models;

public class Reservation {

	
	public String clientName = "";
	
	public Integer tableNumber = 0;
	public Integer seatsCount  = 0;
	public Boolean isSmokingTable = false;
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

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

	public Boolean getIsSmokingTable() {
		return isSmokingTable;
	}

	public void setIsSmokingTable(Boolean isSmokingTable) {
		this.isSmokingTable = isSmokingTable;
	}

	public Reservation(String clientName, Integer tableNumber, Integer seatsCount, Boolean isSmokingTable) {
		super();
		this.clientName = clientName;
		this.tableNumber = tableNumber;
		this.seatsCount = seatsCount;
		this.isSmokingTable = isSmokingTable;
	}
}
