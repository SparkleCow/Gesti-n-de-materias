package com.sparklecow.universidad.services;

import com.sparklecow.universidad.entities.HomeworkDto;
import com.sparklecow.universidad.entities.Homework;
import com.sparklecow.universidad.entities.Subject;
import com.sparklecow.universidad.repositories.HomeworkRepository;
import com.sparklecow.universidad.repositories.SubjectRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworksServiceImp implements HomeworkService{

    private final HomeworkRepository homeworkRepository;
    private final SubjectRepository subjectRepository;
    @Override
    public Homework save(HomeworkDto homeworkDto) {
        Subject subject = subjectRepository.findById(homeworkDto.subjectId())
                .orElseThrow();
        Homework homework = new Homework(
                homeworkDto.title(),
                homeworkDto.description(),
                homeworkDto.homeworkStartAt(),
                homeworkDto.deadline(),
                subject);
        return homeworkRepository.save(homework);
    }

    @Override
    public List<Homework> findAll() {
        return homeworkRepository.findAll();
    }

    @Override
    public Homework findById(Integer id) {
        return homeworkRepository.findById(id).orElseThrow(() -> new NoResultException(""));
    }

    @Override
    public List<Homework> findAllBySubjectId(Integer id) {
        return homeworkRepository.findBySubjectId(id);
    }

    @Override
    public Homework update(HomeworkDto homeworkDto, Integer id) {
        Homework homework = homeworkRepository.findById(id).orElseThrow(() -> new NoResultException(""));
        homework.update(homeworkDto);
        return homeworkRepository.save(homework);
    }

    @Override
    public void delete(Integer id) {
        homeworkRepository.deleteById(id);
    }
}
