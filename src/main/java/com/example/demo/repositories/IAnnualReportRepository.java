package com.example.demo.repositories;

import com.example.demo.entities.AnnualReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnnualReportRepository extends JpaRepository<AnnualReport, Integer> {
}
