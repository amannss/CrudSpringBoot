package in.amanarmy.CrudSpringBootDemo.repository;

import in.amanarmy.CrudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
// this will connect  to database
// < student , primary key type >
// if not interface than we have to write query manually
// so we will use jpa methods
// ye annoatation bhi important nahi hai
@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

}


















//
//public class StudentRepository {
//    public Student savestudent(Student studentreq)
//    {
//        System.out.println("student repository");
//        // this is dummy student , actual will be fetched from database
//        Student s1 = new Student() ;
//        s1.setAge(15);
//        s1.setEmail("aman@gmail.com");
//        s1.setName("aman");
//        s1.setSubject("scince");
//        s1.setRollno(15);
//
//        return s1 ;
//    }
//}
