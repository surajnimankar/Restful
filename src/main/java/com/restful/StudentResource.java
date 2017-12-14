package com.restful;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response findStudentByRollNo(@PathParam("rollno") String rollNo) {
        if(rollNo == null || rollNo.equalsIgnoreCase("null")) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Student student = repository.findStudentByRollNo(rollNo);
        if(student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(student).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student createStudent(Student student) {
        return repository.createStudent(student);
    }
}
