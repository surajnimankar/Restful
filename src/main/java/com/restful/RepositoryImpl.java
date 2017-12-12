package com.restful;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {


    @Override
    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student();
        student1.setName("Suraj Nimankar");
        student1.setRollNo(1);

        students.add(student1);

        Student student2 = new Student();
        student2.setName("Sachin Nimankar");
        student2.setRollNo(2);

        students.add(student2);

        return students;
    }

    @Override
    public Student findStudentByRollNo(int rollNo){
        System.out.println("**********************Looking for RollNo: " + rollNo);
        Student student1 = new Student();
        student1.setName("Suraj Nimankar");
        student1.setRollNo(1);

        return student1;
    }

    @Override
    public Student createStudent(Student student){
        System.out.println("Hurrrrey we have got the student object...!!!");

        return student;
    }
}
