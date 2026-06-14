package com.jpa.FFEOE.BaseDatos.Service;

import com.jpa.FFEOE.BaseDatos.Entity.CambioToner;
import com.jpa.FFEOE.BaseDatos.Entity.Empleado;
import com.jpa.FFEOE.BaseDatos.Entity.Impresora;
import com.jpa.FFEOE.BaseDatos.Entity.Toner;
import com.jpa.FFEOE.BaseDatos.Repository.CambioTonerRepository;
import com.jpa.FFEOE.BaseDatos.Repository.EmpleadoRepository;
import com.jpa.FFEOE.BaseDatos.Repository.ImpresoraRepository;
import com.jpa.FFEOE.BaseDatos.Repository.TonerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CambioTonerService {

    @Autowired
    private CambioTonerRepository cambioTonerRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ImpresoraRepository impresoraRepository;

    @Autowired
    private TonerRepository tonerRepository;

    @Autowired
    private TonerService tonerService;

    public List<CambioToner> findAll() {
        return cambioTonerRepository.findAll();
    }

    public CambioToner save(CambioToner cambioToner) {

        if (cambioToner.getEmpleado() != null) {
            Empleado empleado = empleadoRepository.findById(cambioToner.getEmpleado().getId())
                    .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
            cambioToner.setEmpleado(empleado);
        }

        if (cambioToner.getImpresora() != null) {
            Impresora impresora = impresoraRepository.findById(cambioToner.getImpresora().getId())
                    .orElseThrow(() -> new RuntimeException("Impresora no encontrada"));
            cambioToner.setImpresora(impresora);
        }

        if (cambioToner.getToner() != null) {
            Toner toner = tonerRepository.findById(cambioToner.getToner().getId())
                    .orElseThrow(() -> new RuntimeException("Toner no encontrado"));
            cambioToner.setToner(toner);
        }

        return cambioTonerRepository.save(cambioToner);
    }

    public CambioToner update(Long id, CambioToner cambioToner) {
        CambioToner existing = cambioTonerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cambio de tóner no encontrado con id: " + id));

        existing.setFecha(cambioToner.getFecha());
        existing.setEmpleado(cambioToner.getEmpleado());
        existing.setImpresora(cambioToner.getImpresora());
        existing.setToner(cambioToner.getToner());

        return cambioTonerRepository.save(existing);
    }

    public List<CambioToner> findByEmpleadoId(Long empleadoId) {
        return cambioTonerRepository.findByEmpleadoId(empleadoId);
    }

    public List<CambioToner> findByImpresoraId(Long impresoraId) {
        return cambioTonerRepository.findByImpresoraId(impresoraId);
    }

    public List<CambioToner> findByFecha(LocalDate fecha) {
        return cambioTonerRepository.findByFecha(fecha);
    }

    public void deleteById(Long id) {
        cambioTonerRepository.deleteById(id);
    }

}
