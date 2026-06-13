package com.jpa.FFEOE.BaseDatos.Controllers;

import com.jpa.FFEOE.BaseDatos.Entity.Impresora;
import com.jpa.FFEOE.BaseDatos.Service.ImpresoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/impresoras")
public class ImpresoraController {

    @Autowired
    private ImpresoraService impresoraService;

    @GetMapping
    public List<Impresora> getAll() {
        return impresoraService.findAll();
    }


    @PostMapping
    public ResponseEntity<Impresora> create(@RequestBody Impresora impresora) {
        return new ResponseEntity<>(impresoraService.save(impresora), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Impresora> update(@PathVariable Long id, @RequestBody Impresora impresora) {
        try {
            return ok(impresoraService.update(id, impresora));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        impresoraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/estado/{estado}")
    public List<Impresora> getByEstado(@PathVariable String estado) {
        return impresoraService.ImpresoraPorEstado(estado);
    }
}