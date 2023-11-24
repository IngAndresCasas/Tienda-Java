package com.udea.app.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "empleados")
public class Empleado  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nombre1;
    private String nombre2 ;
    private String apellido1;
    private String apellido2 ;
    private String telefono ;
    private String direccion ;
    private String correo ;
    private boolean estado ;
    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

}