package com.example.SpringDataJpa3;

import com.example.SpringDataJpa3.entity.Employee;
import com.example.SpringDataJpa3.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testQueryByExample1() {
        Employee employee = new Employee();
        employee.setLastName("Smith");
        employee.setLevel(2);
        Example<Employee> example = Example.of(employee);
        List<Employee> employees = employeeRepository.findAll(example);
        Assertions.assertEquals(2, employees.size());
        System.out.println(employees);
    }

    @Test
    public void testQueryByExample2() {
        Employee employee = new Employee();
        employee.setLastName("Smith");
        Example<Employee> example = Example.of(employee);
        List<Employee> employees = employeeRepository.findAll(example);
        Assertions.assertEquals(0, employees.size());
        System.out.println(employees.size());
    }

    @Test
    public void testQueryByExample3() {
        Employee employee = new Employee();
        employee.setLastName("Smith");

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("level");
        Example<Employee> example = Example.of(employee, matcher);

        List<Employee> employees = employeeRepository.findAll(example);
        Assertions.assertEquals(3, employees.size());
        System.out.println(employees);
    }

    @Test
    public void testQueryByExample4() {
        Employee employee = new Employee();
        employee.setFirstName("s");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("level")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING) //Their lastName starts with "Smith"
                .withIgnoreCase();
        Example<Employee> example = Example.of(employee, matcher);

        List<Employee> employees = employeeRepository.findAll(example);
        Assertions.assertEquals(2, employees.size());
        System.out.println(employees);
    }

    @Test
    public void testQueryByExample5() {
        Employee employee = new Employee();
        employee.setFirstName("s");
        employee.setEmail("@else.com");

        ExampleMatcher matcher = ExampleMatcher.matching() // matching = and
                .withIgnorePaths("level")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING) //Their lastName starts with "Smith"
                .withIgnoreCase();
        Example<Employee> example = Example.of(employee, matcher);

        List<Employee> employees = employeeRepository.findAll(example);
        Assertions.assertEquals(0, employees.size());
    }

    @Test
    public void testQueryByExample6() {
        Employee employee = new Employee();
        employee.setFirstName("s");
        employee.setEmail("@else.com");

        ExampleMatcher matcher = ExampleMatcher.matchingAny() // matchingAny = or
                .withIgnorePaths("level")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING) //Their lastName starts with "Smith"
                .withIgnoreCase();
        Example<Employee> example = Example.of(employee, matcher);

        List<Employee> employees = employeeRepository.findAll(example);
        Assertions.assertEquals(2, employees.size());
        System.out.println(employees);
    }

    @Test
    public void testQueryByExample7() {
        Employee employee = new Employee();
        employee.setFirstName("s");
        employee.setEmail("@else.com");

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnorePaths("level")
                .withMatcher("firstName", match -> match.startsWith())
                .withMatcher("email", match -> match.endsWith())
                .withIgnoreCase();
        Example<Employee> example = Example.of(employee, matcher);

        List<Employee> employees = employeeRepository.findAll(example);
        Assertions.assertEquals(1, employees.size());
        System.out.println(employees);
    }

    @BeforeAll
    public void populateData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("gillamy01", "Amy", "Gill", "amy@somewhrelse.com", 1));
        employees.add(new Employee("smithjohn02", "John", "Smith", "john@somewhr.com", 2));
        employees.add(new Employee("lawsonmike03", "Mike", "Lawson", "mike@else.com", 3));
        employees.add(new Employee("lambian03", "Ian", "Lamb", "ian@somewhr.com", 3));
        employees.add(new Employee("bailektora02", "Tora", "Bailek", "tora@somewhr.com", 2));
        employees.add(new Employee("smithsadie01", "Sadie", "Smith", "sadie@somewhrelse.com", 1));
        employees.add(new Employee("ambrizsharon01", "Sharon", "Ambriz", "sharon@else.com", 1));
        employees.add(new Employee("singhrahul02", "Rahul", "Singh", "rahul@somewhr.com", 2));
        employees.add(new Employee("smithjoe02", "Joe", "Smith", "joe@else.com", 2));
        employees.add(new Employee("johnsonleo03", "Leo", "Johnson", "leo@somewhr.com", 3));
        employees.add(new Employee("leebrett04", "Brett", "Lee", "brett@else.com", 4));
        employeeRepository.saveAll(employees);
    }

    @AfterAll
    public void dePopulateData() {
        employeeRepository.deleteAll();
    }

}
