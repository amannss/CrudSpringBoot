package in.amanarmy.CrudSpringBootDemo.service;

import in.amanarmy.CrudSpringBootDemo.entity.Student;
import in.amanarmy.CrudSpringBootDemo.repository.StudentRepository;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.stereotype.Service;

@Service
// this uses component but this one is more specialised
public class StudentService {

    // store in db
    // works as manager between repo and contoller

    private StudentRepository studentrepo ;

    public StudentService(StudentRepository st)
    {
        this.studentrepo = st ;
    }

    public Student createStudent(Student studentreq )
    {
        System.out.println("student service");
        //Student studentresp = studentrepo.savestudent(studentreq) ;
        Student studentresp = studentrepo.save(studentreq) ; // jpa method save
        return studentresp ;

    }
}
