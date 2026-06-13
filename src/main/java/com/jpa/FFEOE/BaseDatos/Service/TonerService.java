package com.jpa.FFEOE.BaseDatos.Service;

import com.jpa.FFEOE.BaseDatos.Entity.Toner;
import com.jpa.FFEOE.BaseDatos.Repository.TonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TonerService {

    @Autowired
    private TonerRepository tonerRepository;

    public List<Toner> findAll() {
        return tonerRepository.findAll();
    }

    public Toner save(Toner toner) {
        return tonerRepository.save(toner);
    }

    public Toner update(Long id, Toner toner) {
        Toner existing = tonerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Toner no encontrado con id: " + id));

        existing.setModelo(toner.getModelo());
        existing.setColor(toner.getColor());
        existing.setStock(toner.getStock());

        return tonerRepository.save(existing);
    }

    public void deleteById(Long id) {
        tonerRepository.deleteById(id);
    }

    // Reducir stock cuando se usa un tóner
    public Toner reducirStock(Long id, int cantidad) {
        Toner toner = tonerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Toner no encontrado"));

        toner.setStock(toner.getStock() - cantidad);
        return tonerRepository.save(toner);
    }

    public List<Toner> findByStockMenor(Integer limite) {
        return tonerRepository.findByStockLessThan(limite);
    }
}
