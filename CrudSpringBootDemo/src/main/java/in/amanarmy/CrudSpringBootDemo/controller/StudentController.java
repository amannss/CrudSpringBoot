package in.amanarmy.CrudSpringBootDemo.controller;

import in.amanarmy.CrudSpringBootDemo.entity.Student;
import in.amanarmy.CrudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService ;
    public StudentController(StudentService ss )
    {
        this.studentService = ss;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student s){
            System.out.println("student controller");
            Student createdStudent = studentService.createStudent(s) ;
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Student studentResp =  studentService.getStudent(id) ;
        if(studentResp == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp) ;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent() ;
        if(studentList.isEmpty())
        {
            return ResponseEntity.notFound().build() ;
        }
        return ResponseEntity.ok(studentList) ;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id , @RequestBody Student s ) {
        Student studentResp = studentService.updateStudent(id , s ) ;
        if(studentResp == null)
        {
            return ResponseEntity.notFound().build() ;
        }
        return ResponseEntity.ok(studentResp) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id ){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Records deleted") ;
    }
}

// create   - post
// read one - get
// read all - get
// update   - put
// delete   - delete