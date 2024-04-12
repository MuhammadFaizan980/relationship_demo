package com.example.demo;

import com.example.demo.dtos.annual_report.AnnualReportRequest;
import com.example.demo.entities.AnnualReport;
import com.example.demo.mappers.AnnualReportMapper;
import org.junit.jupiter.api.*;

class OneToOneRelExampleApplicationTests {
    private AnnualReportMapper annualReportMapper;

    @BeforeAll
    static void beforeAll() {
        // called just once before execution of tests begins
    }

    @AfterAll
    static void afterAll() {
        // called just once after all tests are completed
    }

    @BeforeEach
    void setUp() {
        // called before each test
        annualReportMapper = new AnnualReportMapper();
    }

    @AfterEach
    void tearDown() {
        // called at the end of each test
    }

    @Test
    public void toAnnualReportTest() {
        AnnualReportRequest annualReportRequest = new AnnualReportRequest("a", 3.21);
        AnnualReport annualReport = annualReportMapper.toAnnualReport(annualReportRequest);
        Assertions.assertEquals(annualReport.getStudentGrade(), annualReportRequest.studentGrade());
        Assertions.assertEquals(annualReport.getStudentGpa(), annualReportRequest.studentGpa());
    }
}
