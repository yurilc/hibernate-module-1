package com.wipro.topgear.hibernate.domain;

public class ContractEmployee extends Employee {
    private Double allowance;

    public ContractEmployee() {
    }

    public ContractEmployee(Long employeeId, String employeeName, String employeeBand, Double salary, Double allowance) {
        super(employeeId, employeeName, employeeBand, salary);
        this.allowance = allowance;
    }

    public Double getAllowance() {
        return allowance;
    }

    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "employeeId=" + getEmployeeId() +
                ", allowance=" + allowance +
                '}';
    }
}
