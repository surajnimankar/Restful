package com.restful.client;

import com.restful.Student;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class StudentClient {

    private Client client;

    public StudentClient() {
        client = ClientBuilder.newClient();
    }

    public Student getStudent(String rollNo) {
        WebTarget target = client.target("http://localhost:9090/");

        Response response = target.path("students/" + rollNo).request(MediaType.APPLICATION_JSON).get(Response.class);
        if(response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus()+ "There was an error on the server");
        }

        /*String studentJson = target.path("students/" + rollNo).request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(studentJson);*/

        return response.readEntity(Student.class);
    }

    public List<Student> getStudents() {
        WebTarget target = client.target("http://localhost:9090/");

        List<Student> response = target.path("students/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Student>>() {});

        return response;
    }

    public Student createStudent(Student student) {
        WebTarget target = client.target("http://localhost:9090/");

        Response response = target.path("students/").
                request(MediaType.APPLICATION_JSON).
                post(Entity.entity(student, MediaType.APPLICATION_JSON));
        if(response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus()+ "There was an error on the server");
        }
        return response.readEntity(Student.class);
    }

}
