package com.jpa.FFEOE.BaseDatos.Controllers;

import com.jpa.FFEOE.BaseDatos.Entity.CambioToner;
import com.jpa.FFEOE.BaseDatos.Service.CambioTonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cambios-toner")
public class CambioTonerController {

    @Autowired
    private CambioTonerService cambioTonerService;

    @GetMapping
    public List<CambioToner> getAll() {
        return cambioTonerService.findAll();
    }


    @PutMapping("/{id}")
    public ResponseEntity<CambioToner> update(@PathVariable Long id, @RequestBody CambioToner cambioToner) {
        try {
            return ResponseEntity.ok(cambioTonerService.update(id, cambioToner));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cambioTonerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/empleado/{empleadoId}")
    public List<CambioToner> getByEmpleado(@PathVariable Long empleadoId) {
        return cambioTonerService.findByEmpleadoId(empleadoId);
    }

    @GetMapping("/impresora/{impresoraId}")
    public List<CambioToner> getByImpresora(@PathVariable Long impresoraId) {
        return cambioTonerService.findByImpresoraId(impresoraId);
    }

    @GetMapping("/fecha/{fecha}")
    public List<CambioToner> getByFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return cambioTonerService.findByFecha(fecha);
    }
}