package com.sparklecow.universidad.controllers;

import com.sparklecow.universidad.entities.Homework;
import com.sparklecow.universidad.entities.HomeworkDto;
import com.sparklecow.universidad.services.CrudService;
import com.sparklecow.universidad.services.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/homework")
@CrossOrigin("*")
public class HomeworkController{

    private final HomeworkService homeworkService;
    @PostMapping()
    public ResponseEntity<Homework> createHomework(@RequestBody HomeworkDto homeworkDto){
        return ResponseEntity.ok(homeworkService.save(homeworkDto));
    }

    @GetMapping()
    public ResponseEntity<List<Homework>> findAllHomeworks(){
        return ResponseEntity.ok(homeworkService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Homework> findHomeworkById(@PathVariable Integer id){
        return ResponseEntity.ok(homeworkService.findById(id));
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<List<Homework>> findAllHomeworksBySubjectId(@PathVariable Integer id){
        return ResponseEntity.ok(homeworkService.findAllBySubjectId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Homework> updateHomework(@PathVariable Integer id, @RequestBody HomeworkDto homework){
        return ResponseEntity.ok(homeworkService.update(homework, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHomework(@PathVariable Integer id){
        homeworkService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
