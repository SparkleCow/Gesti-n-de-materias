package com.sparklecow.universidad.repositories;

import com.sparklecow.universidad.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM subjects WHERE student_id = :studentId")
    List<Subject> findByStudentId(@Param("studentId") Integer studentId);
}
