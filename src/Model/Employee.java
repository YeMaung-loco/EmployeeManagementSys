package Model;

public class Employee extends PersonInfo {

	private String username;

	private String password;

	private String role;

	private boolean active;

	public Employee() {
		super();
	}

	public Employee(String name, String phone, String email, String address,
			String username, String password,String role, boolean active) {
		super(name, phone, email, address);
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
		
	}

	public void setActive(boolean active) {
		System.out.println("employee.java"+active);
		this.active = active;
	}
	
	public boolean getActive() {
		return active;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
