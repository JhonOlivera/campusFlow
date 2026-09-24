package com.devSenior.campusFlow.cursos.repository;

import com.devSenior.campusFlow.cursos.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}