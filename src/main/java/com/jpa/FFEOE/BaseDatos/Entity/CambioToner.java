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
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @ManyToOne(targetEntity = Impresora.class)
    @JoinColumn(name = "impresora_id")
    private Impresora impresora;

    @ManyToOne(targetEntity = Toner.class)
    @JoinColumn(name = "toner_id")
    private Toner toner;


}
