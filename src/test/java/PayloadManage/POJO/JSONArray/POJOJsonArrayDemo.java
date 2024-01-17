package PayloadManage.POJO.JSONArray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class POJOJsonArrayDemo {
    public static void main(String [] args) throws JsonProcessingException {

        // create first employee
        Employee employee1 = new Employee();
        employee1.setFirstname("Neymar");
        employee1.setLastname("Jr");
        employee1.setAge(30);
        employee1.setGender("Male");
        employee1.setSalary(27378.234);
        employee1.setMarried(false);

        // create second employee
        Employee employee2 = new Employee();
        employee2.setFirstname("Luke");
        employee2.setLastname("Martins");
        employee2.setAge(25);
        employee2.setGender("Female");
        employee2.setSalary(23823.02);
        employee2.setMarried(true);

        // creating list of employees
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        ObjectMapper objectMapper = new ObjectMapper();
        String allEmployeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);
        System.out.println(allEmployeeJson);

        // Get POJO from Employees
        ObjectMapper objectMapper1 = new ObjectMapper();
        List<Employee> allEmployeeDetails = objectMapper1.readValue(allEmployeeJson, new TypeReference<List<Employee>>() {
        });

        for (Employee emp : allEmployeeDetails){
            System.out.println("========================================================");
            System.out.println("First Name of employee : " + emp.getFirstname());
            System.out.println("Last Name of employee : " + emp.getLastname());
            System.out.println("Age of employee : " + emp.getAge());
            System.out.println("Gender of employee : " + emp.getGender());
            System.out.println("Salary of employee : " + emp.getSalary());
            System.out.println("Marital status of employee : " + emp.isMarried());
            System.out.println("========================================================");
        }
    }
}
