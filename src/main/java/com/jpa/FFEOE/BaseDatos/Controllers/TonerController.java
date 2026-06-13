package com.jpa.FFEOE.BaseDatos.Controllers;

import com.jpa.FFEOE.BaseDatos.Entity.Toner;
import com.jpa.FFEOE.BaseDatos.Service.TonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/toners")
public class TonerController {

    @Autowired
    private TonerService tonerService;

    @GetMapping
    public List<Toner> getAll() {
        return tonerService.findAll();
    }


    @PostMapping
    public ResponseEntity<Toner> create(@RequestBody Toner toner) {
        return new ResponseEntity<>(tonerService.save(toner), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Toner> update(@PathVariable Long id, @RequestBody Toner toner) {
        try {
            return ResponseEntity.ok(tonerService.update(id, toner));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tonerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stock-bajo")
    public List<Toner> getStockBajo(@RequestParam(defaultValue = "5") int limite) {
        return tonerService.findByStockMenor(limite);
    }

    @PatchMapping("/{id}/reducir-stock")
    public ResponseEntity<Toner> reducirStock(@PathVariable Long id, @RequestParam int cantidad) {
        try {
            return ResponseEntity.ok(tonerService.reducirStock(id, cantidad));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}