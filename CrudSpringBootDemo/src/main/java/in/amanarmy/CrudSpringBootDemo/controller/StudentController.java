package in.amanarmy.CrudSpringBootDemo.controller;

import in.amanarmy.CrudSpringBootDemo.entity.Student;
import in.amanarmy.CrudSpringBootDemo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService ;
    public StudentController(StudentService ss )
    {
        this.studentService = ss;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student s){

            System.out.println("student controller");
            Student createdStudent = studentService.createStudent(s) ;
            return createdStudent ;
    }
    @PostMapping("/read")
    public String readStudent(@RequestBody Student s) {

        System.out.println("student controller");
        System.out.println(s.getName());
        System.out.println(s.getEmail());

        return "readStudent";
    }
}
