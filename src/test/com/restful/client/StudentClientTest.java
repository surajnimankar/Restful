package com.restful.client;

import com.restful.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentClientTest {

    @Test
    public void testGetStudent() {
        StudentClient client = new StudentClient();
        Student student = client.getStudent("1");

        assertNotNull(student);
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithBadRequest() {
        StudentClient client = new StudentClient();
        client.getStudent(null);
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithNotFound() {
        StudentClient client = new StudentClient();
        client.getStudent("100");
    }

    @Test
    public void testGetStudents() {
        StudentClient client = new StudentClient();
        List<Student> students = client.getStudents();

        assertNotNull(students);
    }

    @Test
    public void testCreateStudent() {
        StudentClient client = new StudentClient();
        Student student = new Student();
        student.setRollNo(10);
        student.setName("ANCDASD");
        student = client.createStudent(student);

        assertNotNull(student);
    }
}