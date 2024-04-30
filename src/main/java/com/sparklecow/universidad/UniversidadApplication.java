package com.sparklecow.universidad;

import com.sparklecow.universidad.entities.Student;
import com.sparklecow.universidad.entities.Subject;
import com.sparklecow.universidad.repositories.StudentRepository;
import com.sparklecow.universidad.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversidadApplication.class, args);
	}
}
