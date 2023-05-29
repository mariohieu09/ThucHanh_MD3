package DAO;

import Model.department;
import Model.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class employeeDAO implements iEmployeeDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/thuchanh?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_EMPLOYEE = "INSERT INTO employee (name, email, address, phone, salary, department_id) values(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET name = ?, email = ?, address = ?, phone = ?, salary = ?, department_id = ? where id = ?";
    private static final String DELTE_EMPLOYEE = "DELETE from employee where id = ?";
    private static final String GET_EMPLOYEE = "SELECT * from employee where id = ?";
    private static final String GET_LIST_EMPLOYEE = "SELECT * from employee";
    private static final String GET_EMPLOYEE_BY_NAME = "SELECT * from employee where name = ?";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void updateEmployee(String name, String email, String address, String phoneNum, double salary, int  department_id, int id) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, address);
            statement.setString(4, phoneNum);
            statement.setDouble(5, salary);
            statement.setInt(6, department_id);
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(int employee_id) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELTE_EMPLOYEE);
            statement.setInt(1, employee_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertEmployee(employee e) {
        try(Connection connection = getConnection()){
            String name = e.getName();
            String email = e.getEmail();
            String address = e.getAddress();
            String phone = e.getPhoneNum();
            double salary = e.getSalary();
            int department_id = e.getDepartment_id();
            PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, address);
            statement.setString(4, phone);
            statement.setDouble(5, salary);
            statement.setInt(6, department_id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public employee selectEmployee(int id) {
        employee employee = new employee();
       try(Connection connection = getConnection()) {
           PreparedStatement statement = connection.prepareStatement(GET_EMPLOYEE);
           statement.setInt(1, id);
           ResultSet rs = statement.executeQuery();
           while (rs.next()){
               int em_id = rs.getInt("id");
               String name = rs.getString("name");
               String email = rs.getString("email");
               String address = rs.getString("address");
               String phone = rs.getString("phone");
               double salary = rs.getDouble("salary");
               int department_id = rs.getInt("department_id");
               employee = new employee(em_id, name, email, address, phone, salary, department_id);
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return employee;
    }
    public List<employee> employeeList(){
        List<employee> list = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_LIST_EMPLOYEE);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");
                employee employee = new employee(id, name, email, address, phone, salary, department_id);
                list.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public employee selectEmployeeByName(String name){
        employee employee = new employee();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_EMPLOYEE_BY_NAME);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String e_name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");
                employee = new employee(e_name, email, address, phone, salary, department_id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
}
