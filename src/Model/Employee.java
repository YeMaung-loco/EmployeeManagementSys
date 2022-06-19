package Model;

public class Employee {
	String name, addr;
	int salary, id;

	public Employee() {

	}

	public Employee(String name, String addr, int salary) {
		this.name = name;
		this.addr = addr;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
