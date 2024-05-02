package com.sparklecow.universidad.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean status = false;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    @JsonIgnore
    @OneToMany
    private List<Homework> homeworks = new ArrayList<>();

    public Subject(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    public void update(SubjectDto subjectDto) {
        if(subjectDto.name() != null && !subjectDto.name().equalsIgnoreCase("")) {
            this.name = subjectDto.name();
        }
    }
}
