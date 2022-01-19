package com.fst.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;


    public Student create(StudentRequest request) {
        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .cin(request.getCin())
                .phone(request.getPhone())
                .build();
        return studentRepository.save(student);

    }

    public List<Student> findAllStudents () {
        return studentRepository.findAll() ;
    }


    public Optional<Student> findStudentById(Long id ) {
        return studentRepository.findById(id);
    }

    public <S extends Student> S save(S s) {
        return studentRepository.save(s);
    }


    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
