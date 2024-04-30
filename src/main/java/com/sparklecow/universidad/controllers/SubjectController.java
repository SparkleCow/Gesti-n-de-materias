package com.sparklecow.universidad.controllers;

import com.sparklecow.universidad.entities.Subject;
import com.sparklecow.universidad.entities.SubjectDto;
import com.sparklecow.universidad.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping()
    public ResponseEntity<Subject> createSubject(@RequestBody SubjectDto subject){
        return ResponseEntity.ok(subjectService.save(subject));
    }
    @GetMapping()
    public ResponseEntity<List<Subject>> finAllSubjects(){
        return ResponseEntity.ok(subjectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> findSubjectById(@PathVariable Integer id){
        return ResponseEntity.ok(subjectService.findById(id));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<Subject>> findSubjectByStudentId(@PathVariable Integer id){
        return ResponseEntity.ok(subjectService.findByStudentId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Integer id, @RequestBody SubjectDto subject){
        return ResponseEntity.ok(subjectService.update(subject, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Integer id){
        subjectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
