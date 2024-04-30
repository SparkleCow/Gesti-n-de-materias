package com.sparklecow.universidad.services;

import com.sparklecow.universidad.entities.Student;
import com.sparklecow.universidad.entities.StudentDto;
import com.sparklecow.universidad.repositories.StudentRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements CrudService<Student, StudentDto>{
    private final StudentRepository studentRepository;
    @Override
    public Student save(StudentDto studentDto) {
        Student student = new Student(null, studentDto.firstName(),
                studentDto.lastName(), List.of());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new NoResultException(""));
    }

    @Override
    public Student update(StudentDto studentDto, Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NoResultException(""));
        student.update(studentDto);
        return studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
