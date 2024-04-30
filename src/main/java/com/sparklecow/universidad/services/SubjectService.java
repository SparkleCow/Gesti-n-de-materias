package com.sparklecow.universidad.services;

import com.sparklecow.universidad.entities.Subject;
import com.sparklecow.universidad.entities.SubjectDto;

import java.util.List;

public interface SubjectService extends CrudService<Subject, SubjectDto> {
    List<Subject> findByStudentId(Integer studentId);
}
