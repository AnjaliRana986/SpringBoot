package com.anjali.springboot.springjpaandhibernate.course.springdataJpa;

import  java.util.List;
import com.anjali.springboot.springjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpa extends JpaRepository<Course,Long> {

    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);


}
