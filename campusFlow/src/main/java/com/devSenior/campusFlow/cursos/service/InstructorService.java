package com.devSenior.campusFlow.cursos.service;

import com.devSenior.campusFlow.common.exception.ResourceNotFoundException;
import com.devSenior.campusFlow.cursos.model.Instructor;
import com.devSenior.campusFlow.cursos.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> listarTodos() {
        return instructorRepository.findAll();
    }

    public Instructor obtenerPorId(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor no encontrado con id: " + id));
    }

    public Instructor crear(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor actualizar(Long id, Instructor datos) {
        Instructor instructor = obtenerPorId(id);
        instructor.setNombre(datos.getNombre());
        instructor.setEmail(datos.getEmail());
        instructor.setEspecialidad(datos.getEspecialidad());
        return instructorRepository.save(instructor);
    }

    public void eliminar(Long id) {
        Instructor instructor = obtenerPorId(id);
        instructorRepository.delete(instructor);
    }
}