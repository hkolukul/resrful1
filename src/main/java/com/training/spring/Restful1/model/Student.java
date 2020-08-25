package com.training.spring.Restful1.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  int id;
  String name;
  int age;
  String presentClass;
  String city;
  String contact;
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name) { this.name = name; }
  
  public String getPresentClass() {
    return presentClass;
  }
  
  public void setPresentClass(String presentClass) { this.presentClass = presentClass; }
  
  public String getCity() {
    return city;
  }
  
  public void setCity(String city) { this.city = city; }
  
  public String getContact() {
    return contact;
  }
  
  public void setContact(String contact) { this.contact = contact; }
  
  public int getId()
  {
    return id;
  }
  
  public void setId(int id) { this.id = id; }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) { this.age = age; }
  
  public Student(int id, String name, int age, String presentClass, String city, String contact)
  {
    this.id = id;
    this.name = name;
    this.age = age;
    this.presentClass = presentClass;
    this.city = city;
    this.contact = contact;
  }
  
  public Student() {}
}