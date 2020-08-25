package com.training.spring.Restful1.rowMapper;

import com.training.spring.Restful1.model.Student;
import java.sql.ResultSet;

public class StudentMapper implements org.springframework.jdbc.core.RowMapper
{
  public StudentMapper() {}
  
  public Student mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException
  {
    Student student = new Student();
    student.setId(rs.getInt("id"));
    student.setName(rs.getString("name"));
    student.setPresentClass(rs.getString("presentClass"));
    student.setCity(rs.getString("city"));
    student.setContact(rs.getString("contact"));
    student.setAge(rs.getInt("age"));
    return student;
  }
}
