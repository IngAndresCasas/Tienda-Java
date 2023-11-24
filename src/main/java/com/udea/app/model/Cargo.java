package com.udea.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "cargos")
public class Cargo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;
    private String descripcion;
    private boolean estado;
    @OneToMany(mappedBy = "cargo")
    private List<Empleado> empleado;

}