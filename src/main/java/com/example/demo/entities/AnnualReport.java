package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "annual_reports")
public class AnnualReport {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "grade")
    private String studentGrade;
    @Column(name = "gpa")
    private double studentGpa;

    public AnnualReport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public double getStudentGpa() {
        return studentGpa;
    }

    public void setStudentGpa(double studentGpa) {
        this.studentGpa = studentGpa;
    }
}
