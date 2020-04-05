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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SystemUserRole getRole() {
		return role;
	}

	public void setRole(SystemUserRole role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SystemUser [name=" + name + ", role=" + role + ", username=" + username + ", password=" + password
				+ "]";
	}
}
