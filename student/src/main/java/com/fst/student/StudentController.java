package com.fst.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> createStudent (@RequestBody StudentRequest request) {
        if(studentService.create(request) != null) {
            return new ResponseEntity<>("student created" , HttpStatus.OK);
        }
        return new ResponseEntity<>("student already exists" , HttpStatus.CONFLICT);

    }

    @GetMapping("/all")
    public List<Student> getAll () {
        return studentService.findAllStudents();
    }
    @GetMapping(path = "/{id}")
    public Optional<Student> findById(@PathVariable long id)  {

        return studentService.findStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent (@RequestBody StudentRequest newStudent , @PathVariable Long id){
        Student oldStudent = studentService.findStudentById(id).get();
        oldStudent.setFirstName(newStudent.getFirstName());
        oldStudent.setLastName(newStudent.getLastName());
        oldStudent.setCin(newStudent.getCin());
        oldStudent.setPhone(newStudent.getPhone());
        return studentService.save(oldStudent);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        studentService.deleteStudentById(id);
    }
}
