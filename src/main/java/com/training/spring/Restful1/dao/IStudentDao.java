package com.training.spring.Restful1.dao;

import com.training.spring.Restful1.model.Student;
import java.util.List;

public abstract interface IStudentDao
{
  public abstract List<Student> getAllStudents();
  
  public abstract int addStudent(Student paramStudent);
  
  public abstract int findStudent(int paramInt);
  
  public abstract int updateStudent(int paramInt, Student paramStudent);
  
  public abstract int deleteStudent(int paramInt);
}