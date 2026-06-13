package com.jpa.FFEOE.BaseDatos.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Impresora {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String estado;
    private String modelo;
    private String Ubicacion;

    @OneToMany(targetEntity = CambioToner.class, fetch = FetchType.LAZY)
    private List<CambioToner> Cambiotoner;

}
