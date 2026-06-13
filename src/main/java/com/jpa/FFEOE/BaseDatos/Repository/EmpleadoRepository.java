package com.jpa.FFEOE.BaseDatos.Repository;

import com.jpa.FFEOE.BaseDatos.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findByDepartamento(String departamento);

    List<Empleado> findByNombre(String nombre);
}
