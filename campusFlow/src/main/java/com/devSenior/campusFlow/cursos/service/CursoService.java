package com.devSenior.campusFlow.cursos.service;

import com.devSenior.campusFlow.common.exception.ResourceNotFoundException;
import com.devSenior.campusFlow.cursos.model.Curso;
import com.devSenior.campusFlow.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con id: " + id));
    }

    public Curso crear(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso actualizar(Long id, Curso datos) {
        Curso curso = obtenerPorId(id);
        curso.setNombre(datos.getNombre());
        curso.setDescripcion(datos.getDescripcion());
        curso.setCreditos(datos.getCreditos());
        curso.setInstructor(datos.getInstructor());
        return cursoRepository.save(curso);
    }

    public void eliminar(Long id) {
        Curso curso = obtenerPorId(id);
        cursoRepository.delete(curso);
    }
}