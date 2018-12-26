package com.wipro.topgear.hibernate.domain;

public class RegularEmployee extends Employee {
    private Double qplc;

    public RegularEmployee() {
    }

    public RegularEmployee(Long employeeId, String employeeName, String employeeBand, Double salary, Double qplc) {
        super(employeeId, employeeName, employeeBand, salary);
        this.qplc = qplc;
    }

    public Double getQplc() {
        return qplc;
    }

    public void setQplc(Double qplc) {
        this.qplc = qplc;
    }

    @Override
    public String toString() {
        return "RegularEmployee{" +
                "employeeId=" + getEmployeeId() +
                ", qplc=" + qplc +
                '}';
    }
}
