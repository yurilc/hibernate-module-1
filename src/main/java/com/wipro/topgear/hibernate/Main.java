package com.wipro.topgear.hibernate;

import com.wipro.topgear.hibernate.domain.*;
import com.wipro.topgear.hibernate.repository.*;
import com.wipro.topgear.hibernate.repository.impl.*;
import com.wipro.topgear.hibernate.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.Arrays;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        ex1(session);
        ex2(session);
        ex3(session);
        ex4(session);
        ex5(session);

        session.close();
    }

    private static void ex1(Session session) {
        log.info("Running first exercise");
        EmployeeRepository repository = new EmployeeRepositoryImpl(session);

        log.info("Saving employee...");
        Employee employee1 = new Employee();
        employee1.setEmployeeId(1L);
        employee1.setEmployeeName("Employee 1");
        employee1.setEmployeeBand("B1");

        repository.save(employee1);
        log.info("employee saved! {}", employee1);

        log.info("Saving employee...");
        Employee employee2 = new Employee();
        employee2.setEmployeeId(2L);
        employee2.setEmployeeName("Employee 2");
        employee2.setEmployeeBand("B2");

        repository.save(employee2);
        log.info("employee saved! {}", employee2);

        log.info("Updating employee...");
        employee1.setEmployeeName("New employee");
        employee1.setEmployeeBand("C1");

        employee1 = repository.update(employee1);
        log.info("Employee updated! {}", employee1);

        Long id = 1L;

        log.info("Deleting employee: {}...", id);
        repository.delete(id);
        log.info("Employee deleted!");

        id = 2L;
        log.info("Finding employee by id {}...", id);
        Employee employee3 = repository.findById(id);
        log.info("Employee found: {}", employee3);

        log.info("find all: {}", Arrays.toString(repository.findAll().toArray()));

        log.info("First exercise finished!");
    }

    private static void ex2(Session session) {
        log.info("Running second exercise");
        DepartmentRepository departmentRepository = new DepartmentRepositoryImpl(session);
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(session);

        log.info("Saving department with 3 employees...");
        Department department = new Department();
        department.setId(1L);
        department.setName("Human Resources");
        department.getEmployees().add(new Employee(3L, "Employee 3", "AA"));
        department.getEmployees().add(new Employee(4L, "Employee 4", "B1"));
        department.getEmployees().add(new Employee(5L, "Employee 5", "B2"));

        departmentRepository.save(department);
        log.info("Department saved! {}", department);
        log.info("Employees: {}", Arrays.toString(employeeRepository.findAll().toArray()));

        Long id = 1L;

        log.info("Removing 1 employ from department {}", id);
        department = departmentRepository.findById(id);
        department.getEmployees().remove(new Employee(4L, null, null));
        department = departmentRepository.update(department);
        log.info("Department updated! {}", department);
        log.info("Employees: {}", Arrays.toString(employeeRepository.findAll().toArray()));

        log.info("Delete department {}", id);
        departmentRepository.delete(id);
        log.info("Department deleted");
        log.info("Employees: {}", Arrays.toString(employeeRepository.findAll().toArray()));

        log.info("Second exercise finished!");
    }

    private static void ex3(Session session) {
        log.info("Running third exercise");
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(session);
        PassportRepository passportRepository = new PassportRepositoryImpl(session);

        log.info("Saving employee with passport...");
        Passport passport = new Passport(1L, "123456");

        Employee employee = new Employee();
        employee.setEmployeeId(6L);
        employee.setEmployeeName("Employee 6");
        employee.setEmployeeBand("AA");
        employee.setPassport(passport);

        employeeRepository.save(employee);
        log.info("Employee saved! {}", employee);
        log.info("passports: {}", Arrays.toString(passportRepository.findAll().toArray()));

        Long id = 6L;
        log.info("Deleting employee {}", id);
        employeeRepository.delete(id);
        log.info("Employee deleted!");
        log.info("passports: {}", Arrays.toString(passportRepository.findAll().toArray()));

        log.info("Third exercise finished!");
    }

    private static void ex4(Session session) {
        log.info("Running fourth exercise");
        StudentRepository studentRepository = new StudentRepositoryImpl(session);
        CourseRepository courseRepository = new CourseRepositoryImpl(session);

        log.info("Setting up data");
        studentRepository.save(new Student(1L, "Student 1"));
        studentRepository.save(new Student(2L, "Student 2"));
        studentRepository.save(new Student(3L, "Student 3"));

        courseRepository.save(new Course(1L, "Course 1"));
        courseRepository.save(new Course(2L, "Course 2"));
        log.info("Data set up Finished!");

        log.info("Adding courses to students");
        Student student = studentRepository.findById(1L);
        student.getCourses().add(courseRepository.findById(1L));
        studentRepository.save(student);

        student = studentRepository.findById(3L);
        student.getCourses().add(courseRepository.findById(1L));
        student.getCourses().add(courseRepository.findById(2L));
        studentRepository.save(student);

        Long id = 1L;
        log.info("student {} course: {}", id, studentRepository.findById(id).getCourses());
        id = 3L;
        log.info("student {} course: {}", id, studentRepository.findById(id).getCourses());

        log.info("Courses added to students!");

        log.info("Running clean up");
        studentRepository.findAll().forEach(s -> {
            s.getCourses().clear();
            studentRepository.save(s);
        });
        log.info("Clean up finished!");

        log.info("Adding students to courses");
        Course course = courseRepository.findById(1L);
        course.getStudents().add(studentRepository.findById(1L));
        courseRepository.save(course);

        course = courseRepository.findById(2L);
        course.getStudents().add(studentRepository.findById(1L));
        course.getStudents().add(studentRepository.findById(3L));
        courseRepository.save(course);

        id = 1L;
        log.info("course {} students: {}", id, courseRepository.findById(id).getStudents());
        id = 2L;
        log.info("course {} students: {}", id, courseRepository.findById(id).getStudents());

        log.info("Students added to courses!");

        log.info("Fourth exercise finished!");
    }

    private static void ex5(Session session) {
        log.info("Running fifth exercise");
        RegularEmployeeRepository regularEmployeeRepository = new RegularEmployeeRepositoryImpl(session);
        ContractEmployeeRepository contractEmployeeRepository = new ContractEmployeeRepositoryImpl(session);

        log.info("Saving regular employee");
        RegularEmployee regularEmployee = new RegularEmployee(7L, "Employee 7", "B1", 1000.0, 0.2);
        regularEmployeeRepository.save(regularEmployee);

        log.info("Regular employee saved! {}", Arrays.toString(regularEmployeeRepository.findAll().toArray()));

        log.info("Saving contract employee");
        ContractEmployee contractEmployee= new ContractEmployee(8L, "Employee 7", "B1", 2000.0, 2000.0);
        contractEmployeeRepository.save(contractEmployee);

        log.info("Contract employee saved! {}", Arrays.toString(contractEmployeeRepository.findAll().toArray()));

        log.info("Fifth exercise finished!");
    }
}
