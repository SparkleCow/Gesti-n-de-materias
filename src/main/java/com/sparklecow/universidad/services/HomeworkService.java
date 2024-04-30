package com.sparklecow.universidad.services;

import com.sparklecow.universidad.entities.Homework;
import com.sparklecow.universidad.entities.HomeworkDto;

import java.util.List;

public interface HomeworkService extends CrudService<Homework, HomeworkDto>{
    List<Homework> findAllBySubjectId(Integer id);
}
