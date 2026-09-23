package in.amanarmy.CrudSpringBootDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // testing
    private long id ;
    private String name ;
    private int age ;
    private String email ;
    private int rollno ;
    private String subject ;
    private Boolean deleted ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}


// for postman
//{
//		"id" : 1 ,
//		"name" : "aman" ,
//		"age" : 15,
//		"email" : "aman@gmail.com" ,
//		"rollno" : 17 ,
//		"subject" : "science"
//}
//
// http://localhost:8080/api/students/create
