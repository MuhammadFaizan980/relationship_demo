package com.example.demo.repositories;

import com.example.demo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
}
