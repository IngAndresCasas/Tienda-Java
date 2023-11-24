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
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    private boolean estado;
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> producto;

//    @ManyToOne
//    @JoinColumn(name = "id_proveedor")
//    private Producto producto;
}
