package spring_boot.sevice;

import spring_boot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployee(int empId);

    void deleteEmployee(int empId);
}
