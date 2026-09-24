package com.devSenior.campusFlow.cursos.controller;

import com.devSenior.campusFlow.cursos.model.Instructor;
import com.devSenior.campusFlow.cursos.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<Instructor> listar() {
        return instructorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Instructor obtener(@PathVariable Long id) {
        return instructorService.obtenerPorId(id);
    }

    @PostMapping
    public Instructor crear(@RequestBody Instructor instructor) {
        return instructorService.crear(instructor);
    }

    @PutMapping("/{id}")
    public Instructor actualizar(@PathVariable Long id, @RequestBody Instructor instructor) {
        return instructorService.actualizar(id, instructor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        instructorService.eliminar(id);
    }
}