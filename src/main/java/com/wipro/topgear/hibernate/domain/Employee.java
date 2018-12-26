package com.wipro.topgear.hibernate.domain;

import java.io.Serializable;

public class Employee implements Serializable {
    private Long employeeId;
    private String employeeName;
    private String employeeBand;
    private Passport passport;
    private Double salary;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, String employeeBand) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBand = employeeBand;
    }

    public Employee(Long employeeId, String employeeName, String employeeBand, Double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBand = employeeBand;
        this.salary = salary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBand() {
        return employeeBand;
    }

    public void setEmployeeBand(String employeeBand) {
        this.employeeBand = employeeBand;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return getEmployeeId() != null ? getEmployeeId().equals(employee.getEmployeeId()) : employee.getEmployeeId() == null;
    }

    @Override
    public int hashCode() {
        return getEmployeeId() != null ? getEmployeeId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeBand='" + employeeBand + '\'' +
                ", passport=" + passport +
                ", salary=" + salary +
                '}';
    }
}
