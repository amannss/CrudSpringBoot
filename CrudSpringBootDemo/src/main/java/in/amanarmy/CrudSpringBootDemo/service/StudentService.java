package in.amanarmy.CrudSpringBootDemo.service;

import in.amanarmy.CrudSpringBootDemo.entity.Student;
import in.amanarmy.CrudSpringBootDemo.repository.StudentRepository;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    // POST
    public Student createStudent(Student studentreq ) {
//        System.out.println("student service");
        //Student studentresp = studentrepo.savestudent(studentreq) ;
        studentreq.setDeleted(false);
        Student studentresp = studentrepo.save(studentreq) ; // jpa method save
        return studentresp ;
    }


    // GET
    public Student getStudent(Long id ) {
    //  Optional<Student> record =  studentrepo.findById(id) ; // this return optional , value may exist or not
        Optional<Student> record = studentrepo.findByIdAndDeletedIsFalse(id) ;
        if(record.isPresent()) return record.get() ;
        return null ;
    }


    // GET ALL
    public List<Student> getAllStudent() {
        List<Student> StudentList = studentrepo.findAllByDeletedIsFalse() ;
        return StudentList ;
    }


    // UPDATE
    public Student updateStudent(Long id , Student s){
        Optional<Student> studentResp = studentrepo.findById(id) ; // check if record exists or not
        if(studentResp.isEmpty())
        {
            return null ;
        }
        Student studentToSave = studentResp.get() ;

        studentToSave.setRollno(s.getRollno());
        studentToSave.setName(s.getName());
        studentToSave.setSubject(s.getSubject());
        studentToSave.setEmail(s.getEmail());
        studentToSave.setAge(s.getAge());
        studentToSave.setDeleted(false);
        return studentrepo.save(studentToSave) ;
    }


    // DELETE
    public Boolean deleteStudent(Long id ) {
        Boolean isStudent = studentrepo.existsById(id) ;
        if(!isStudent) return false ;
        studentrepo.deleteById(id); // it returns nothing
        return true ;
    }


    // SOFT DELETE
    public Boolean deleteStudentSoftly(Long id){
    //   Optional<Student> isStudent = studentrepo.findById(id) ; // for hard delete
        Optional<Student> isStudent = studentrepo.findByIdAndDeletedIsFalse(id) ;
        if(isStudent.isEmpty())
        {
            return null ;
        }
        // to save in database
        Student studentToSave = isStudent.get()  ;
        studentToSave.setDeleted(true);
        studentrepo.save(studentToSave) ;
        return true;
    }

    public Boolean reverseSoftDelete(Long id ){
        Optional<Student> record = studentrepo.findById(id) ;
        if(record.isEmpty())
        {
            return null ;
        }
        Student studentToSave = record.get() ;
        studentToSave.setDeleted(false);
        studentrepo.save(studentToSave) ;
        return true ;
    }
}
