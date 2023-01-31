package com.e.campus.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "start_date")
    private String startDate;

    @NotNull
    @Column(name = "end_date")
    private String endDate;

    @NotNull
    @Column(name = "salary")
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    public Contract() {}

    public Contract(String startDate, String endDate, Double salary, Staff staff) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.staff = staff;
    }

    public Long getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff employee) {
        this.staff = staff;
    }
}
