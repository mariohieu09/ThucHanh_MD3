package DAO;

import Model.department;
import Model.employee;

public interface iEmployeeDAO {
    void updateEmployee(String name, String email, String address, String phoneNum, double salary, int department_id, int id );
    void deleteEmployee(int employee_id);
    void insertEmployee(employee e);
    employee selectEmployee(int id);
}
