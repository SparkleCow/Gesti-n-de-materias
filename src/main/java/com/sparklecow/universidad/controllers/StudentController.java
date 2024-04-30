package com.sparklecow.universidad.controllers;

import com.sparklecow.universidad.entities.Student;
import com.sparklecow.universidad.entities.StudentDto;
import com.sparklecow.universidad.services.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
@CrossOrigin("*")
public class StudentController {

    private final CrudService<Student, StudentDto> studentService;
    @GetMapping()
    public ResponseEntity<List<Student>> finAllStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody StudentDto student){
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Integer id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody StudentDto student){
        return ResponseEntity.ok(studentService.update(student, id));
    }
}

