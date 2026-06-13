package com.jpa.FFEOE.BaseDatos.Controllers;

import com.jpa.FFEOE.BaseDatos.Entity.Empleado;
import com.jpa.FFEOE.BaseDatos.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAll() {
        return empleadoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Empleado> create(@RequestBody Empleado empleado) {
        return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable Long id, @RequestBody Empleado empleado) {
        try {
            return ResponseEntity.ok(empleadoService.update(id, empleado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empleadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/departamento/{departamento}")
    public List<Empleado> getByDepartamento(@PathVariable String departamento) {
        return empleadoService.EmpleadoPorDepartamento(departamento);
    }
}

