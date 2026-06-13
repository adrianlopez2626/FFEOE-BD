package com.jpa.FFEOE.BaseDatos.Service;

import com.jpa.FFEOE.BaseDatos.Entity.Impresora;
import com.jpa.FFEOE.BaseDatos.Repository.ImpresoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpresoraService {

    @Autowired
    private ImpresoraRepository impresoraRepository;

    public List<Impresora> findAll() {
        return impresoraRepository.findAll();
    }

    public Impresora save(Impresora impresora) {
        return impresoraRepository.save(impresora);
    }

    public Impresora update(Long id, Impresora impresora) {
        Impresora existing = impresoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Impresora no encontrada con id: " + id));

        existing.setModelo(impresora.getModelo());
        existing.setUbicacion(impresora.getUbicacion());
        existing.setEstado(impresora.getEstado());

        return impresoraRepository.save(existing);
    }

    public void deleteById(Long id) {
        impresoraRepository.deleteById(id);
    }

    public List<Impresora> ImpresoraPorEstado(String estado) {
        return impresoraRepository.findByEstado(estado);
    }
}