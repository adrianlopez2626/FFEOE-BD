package com.jpa.FFEOE.BaseDatos.Service;

import com.jpa.FFEOE.BaseDatos.Entity.Empleado;
import com.jpa.FFEOE.BaseDatos.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Obtener todos
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    // Guardar
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // Actualizar
    public Empleado update(Long id, Empleado empleado) {
        Empleado existing = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));

        existing.setNombre(empleado.getNombre());
        existing.setDepartamento(empleado.getDepartamento());

        return empleadoRepository.save(existing);
    }

    // Eliminar
    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }

    // Métodos adicionales
    public List<Empleado> EmpleadoPorDepartamento(String departamento) {
        return empleadoRepository.findByDepartamento(departamento);
    }

}
