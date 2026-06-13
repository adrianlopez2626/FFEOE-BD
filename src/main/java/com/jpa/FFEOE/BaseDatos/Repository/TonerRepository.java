package com.jpa.FFEOE.BaseDatos.Repository;

import com.jpa.FFEOE.BaseDatos.Entity.Toner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TonerRepository extends JpaRepository<Toner, Long> {

    List<Toner> findByColor(String color);

    List<Toner> findByStockLessThan(Integer stock);

    List<Toner> findByModelo(String modeloToner);
}
