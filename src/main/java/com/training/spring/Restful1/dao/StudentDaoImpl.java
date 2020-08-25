package com.training.spring.Restful1.dao;

import com.training.spring.Restful1.model.Student;
import com.training.spring.Restful1.rowMapper.StudentMapper;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service("studentdao")
public class StudentDaoImpl
  implements IStudentDao
{
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  public StudentDaoImpl() {}
  
  private static final Logger logger = Logger.getLogger(StudentDaoImpl.class);
  
  public List<Student> getAllStudents() {
    String sql = "select * from ogm_stage.student";
    logger.debug("Select all query : " + sql);
    return jdbcTemplate.query(sql, new StudentMapper());
  }
  
  public int addStudent(Student student) {
    String sql = "insert into ogm_stage.Student(id,age,contact,name,presentclass,city) values(?,?,?,?,?,?)";
    logger.debug("Add query : " + sql);
    return jdbcTemplate.update(sql, new Object[] { Integer.valueOf(student.getId()), Integer.valueOf(student.getAge()), student.getContact(), 
      student.getName(), student.getPresentClass(), student.getCity() });
  }
  
  public int findStudent(int id) {
    String sql = "select * from ogm_stage.Student where id=?";
    logger.debug("Finding student query : " + sql);
    List<Student> students = jdbcTemplate.query(sql, new Object[] { Integer.valueOf(id) }, new StudentMapper());
    logger.debug("Finding student query returned " + students.size() + " records");
    return students.size();
  }
  
  public int updateStudent(int id, Student student)
  {
    String sql = "update ogm_stage.Student set age=? , contact=?, name=?, presentClass=?,city=? where id=?";
    logger.debug("Update query : " + sql);
    return jdbcTemplate.update(sql, new Object[] { Integer.valueOf(student.getAge()), student.getContact(), student.getName(), 
      student.getPresentClass(), student.getCity(), Integer.valueOf(id) });
  }
  
  public int deleteStudent(int id)
  {
    String sql = "delete from ogm_stage.Student where id=?";
    logger.debug("Delete query : " + sql);
    return jdbcTemplate.update(sql, new Object[] { Integer.valueOf(id) });
  }
}

