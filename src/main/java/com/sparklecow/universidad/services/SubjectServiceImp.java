package com.sparklecow.universidad.services;

import com.sparklecow.universidad.entities.Subject;
import com.sparklecow.universidad.entities.SubjectDto;
import com.sparklecow.universidad.repositories.SubjectRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImp implements SubjectService{

    private final SubjectRepository subjectRepository;
    private final StudentServiceImp studentServiceImp;
    @Override
    public Subject save(SubjectDto subjectDto) {
        Subject subject = new Subject(subjectDto.name(),
                studentServiceImp.findById(subjectDto.studentId()));
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Integer id) {
        return subjectRepository.findById(id).orElseThrow(() -> new NoResultException(""));
    }

    @Override
    public List<Subject> findByStudentId(Integer id){
        return subjectRepository.findByStudentId(id);
    }

    @Override
    public Subject update(SubjectDto subjectdto, Integer id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new NoResultException(""));
        subject.update(subjectdto);
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Integer id) {
        subjectRepository.deleteById(id);
    }
}
