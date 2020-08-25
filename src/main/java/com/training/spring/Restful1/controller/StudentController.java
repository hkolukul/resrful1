package com.training.spring.Restful1.controller;

import com.training.spring.Restful1.dao.IStudentDao;
import com.training.spring.Restful1.model.Student;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;







@Path("/students")
public class StudentController
{
  private static final Logger logger = Logger.getLogger(StudentController.class);
  @Autowired
  @Qualifier("studentdao")
  private IStudentDao studentDaoImpl;
  
  public StudentController() {}
  
  @PostConstruct
  public void init() {
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  }
  
  @GET
  @Produces({"application/json"})
  public List<Student> getAllstudents()
  {
    logger.info("Getting all students");
    List<Student> students = studentDaoImpl.getAllStudents();
    logger.debug("Returned " + students.size() + " students");
    return students;
  }
  
  @POST
  @Path("/addStudent")
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public String addStudent(Student student) {
    logger.info("Adding student");
    int status = studentDaoImpl.addStudent(student);
    logger.debug("Added " + student.getName());
    return "Addition status: " + status;
  }
  
  @PUT
  @Path("/updateStudent/{id}")
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public String updateStudent(@PathParam("id") int id, Student student)
  {
    int status = -1;
    logger.info("Updating student");
    if (studentDaoImpl.findStudent(id) == 1) {
      status = studentDaoImpl.updateStudent(id, student);
      logger.debug("Updated student " + student.getName());
    } else {
      logger.error("Student with " + id + " not found");
    }
    return "update status: " + status;
  }
  
  @DELETE
  @Path("/deleteStudent/{id}")
  @Produces({"application/json"})
  public void deleteStudent(@PathParam("id") int id) {
    logger.info("Updating student");
    if (studentDaoImpl.findStudent(id) == 1) {
      studentDaoImpl.deleteStudent(id);
      logger.debug("Deleted student " + id);
    } else {
      logger.error("Student with " + id + " not found");
    }
  }
}