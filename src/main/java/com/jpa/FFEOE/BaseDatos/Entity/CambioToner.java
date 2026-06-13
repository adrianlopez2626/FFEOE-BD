package com.jpa.FFEOE.BaseDatos.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CambioToner {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String tipo;
    private LocalDate fecha;

    @ManyToOne(targetEntity = Empleado.class)
    private Empleado empleado;

    @ManyToOne(targetEntity = Impresora.class)
    private Impresora impresora;

    @ManyToOne(targetEntity = Toner.class)
    private Toner toner;


}
