package com.restful;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("students")
public class StudentResource {

    Repository repository =  new RepositoryImpl();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findAllStudents() {
        return repository.findAllStudents();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{rollno}")
    public Student findStudentByRollNo(@PathParam("rollno") int rollNo) {
        return repository.findStudentByRollNo(rollNo);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student createStudent(Student student) {
        return repository.createStudent(student);
    }
}
