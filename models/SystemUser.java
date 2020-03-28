package models;

public class SystemUser {
	public String name;
	public SystemUserRole role;
	public String username;
	public String password;
	
	public SystemUser(String name, String role, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		
		switch (role) {
		case "Manager":
			this.role = SystemUserRole.MANAGER;
			break;
		case "Waiter":
			this.role = SystemUserRole.WAITER;
			break;
		case "Cooker":
			this.role = SystemUserRole.CHEF;
			break;
		case "Client":
			this.role = SystemUserRole.CLIENT;
			break;
		}
	}
}
