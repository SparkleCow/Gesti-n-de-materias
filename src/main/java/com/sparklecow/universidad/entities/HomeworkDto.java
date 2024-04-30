package com.sparklecow.universidad.entities;
import java.time.LocalDateTime;

public record HomeworkDto(String title,
                          String description,
                          LocalDateTime homeworkStartAt,
                          LocalDateTime deadline,
                          Integer subjectId) {
}