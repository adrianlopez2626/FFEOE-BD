package com.jpa.FFEOE.BaseDatos.Repository;

import com.jpa.FFEOE.BaseDatos.Entity.Impresora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImpresoraRepository extends JpaRepository<Impresora, Long> {

    List<Impresora> findByEstado(String estado);
}