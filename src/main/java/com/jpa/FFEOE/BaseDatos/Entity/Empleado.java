package com.jpa.FFEOE.BaseDatos.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Lazy;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private long DNI;
    private String departamento;

    @OneToMany(targetEntity = CambioToner.class, fetch = FetchType.LAZY)
    private List<CambioToner> Cambiotoner;

}
