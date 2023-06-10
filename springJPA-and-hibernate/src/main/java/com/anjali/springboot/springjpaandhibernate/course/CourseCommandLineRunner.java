package com.anjali.springboot.springjpaandhibernate.course;

import com.anjali.springboot.springjpaandhibernate.course.Course;
import com.anjali.springboot.springjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.anjali.springboot.springjpaandhibernate.course.jpa.CourseJpaRepository;
import com.anjali.springboot.springjpaandhibernate.course.springdataJpa.CourseSpringDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;
//    @Autowired
//    private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpa repository;
    @Override
    public void run(String... args) throws Exception {
            repository.save(new Course(1,"Learn AWS JPA","Anjali"));
            repository.save(new Course(2,"Learn Azure ","Anjali"));
            repository.save(new Course(3,"Learn Google Cloud","Anjali"));
            repository.save(new Course(4,"Learn Devops","Anjali"));
            repository.deleteById(2l);
            System.out.println(repository.findById(2l));
            //System.out.println(repository.findByID(3L));
            System.out.println(repository.findAll());
            System.out.println(repository.count());
            System.out.println((repository.findByAuthor("Anjali")));
            System.out.println((repository.findByAuthor("")));
            System.out.println((repository.findByName("Learn AWS JPA  ")));


    }
}
