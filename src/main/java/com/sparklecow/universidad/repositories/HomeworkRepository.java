package com.sparklecow.universidad.repositories;

import com.sparklecow.universidad.entities.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM homeworks WHERE subject_id = :subjectId")
    List<Homework> findBySubjectId(@Param("subjectId") Integer subjectId);
}
