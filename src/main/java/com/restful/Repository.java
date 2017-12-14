package com.restful;

import java.util.List;

public interface Repository {
    List<Student> findAllStudents();

    Student findStudentByRollNo(String rollNo);

    Student createStudent(Student student);
}
