package com.sparklecow.universidad.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="homeworks")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime homeworkStartAt = LocalDateTime.now();
    private LocalDateTime deadline;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    public Homework(String title, String description, LocalDateTime homeworkStartAt, LocalDateTime deadline, Subject subject) {
        this.title = title;
        this.description = description;
        this.homeworkStartAt = homeworkStartAt;
        this.deadline = deadline;
        this.subject = subject;
    }

    public void update(HomeworkDto homeworkDto) {
        if(homeworkDto.title() != null && !homeworkDto.title().equalsIgnoreCase("")) {
            this.title = homeworkDto.title();
        }
        if(homeworkDto.description() != null && !homeworkDto.description().equalsIgnoreCase("")) {
            this.description = homeworkDto.description();
        }
        if(homeworkDto.homeworkStartAt() != null) {
            this.homeworkStartAt = homeworkDto.homeworkStartAt();
        }
        if(homeworkDto.deadline() != null) {
            this.deadline = homeworkDto.deadline();
        }
    }
}
