package Model;

public class employee {
    private int id;
    private String name;
    private String email;
    private String Address;
    private String phoneNum;
    private double salary;
    private int department_id;

    public employee(int id, String name, String email, String address, String phoneNum, double salary, int department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.Address = address;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.department_id = department;
    }

    public employee(String name, String email, String address, String phoneNum, double salary, int department_id) {
        this.name = name;
        this.email = email;
        Address = address;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.department_id = department_id;
    }

    public employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
