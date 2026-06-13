package com.jpa.FFEOE.BaseDatos.Repository;

import com.jpa.FFEOE.BaseDatos.Entity.CambioToner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CambioTonerRepository extends JpaRepository<CambioToner, Long> {


    List<CambioToner> findByEmpleadoId(Long empleadoId);

    List<CambioToner> findByImpresoraId(Long impresoraId);

    List<CambioToner> findByFecha(LocalDate fecha);
}
