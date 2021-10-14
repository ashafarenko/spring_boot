package spring_boot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring_boot.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
////        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int empId) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, empId);
        Employee employee = entityManager.find(Employee.class, empId);
        return employee;
    }

    @Override
    public void deleteEmployee(int empId) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee " +
//                "where id = :empId");
//        query.setParameter("empId", empId);
//        query.executeUpdate();
//        Employee employee = session.get(Employee.class, empId);
//        session.delete(employee);
        Query query = entityManager.createQuery("delete from Employee " +
                "where id = :empId");
        query.setParameter("empId", empId);
        query.executeUpdate();
    }
}
