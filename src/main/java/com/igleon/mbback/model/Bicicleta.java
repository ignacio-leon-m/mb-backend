package com.igleon.mbback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by ignac on 30-06-2023.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bicicleta")
public class Bicicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "aro")
    private int aro;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "color")
    private String color;
    @Column(name = "estado")
    private String estado;
    @Column(name = "precio_arr")
    private String precioArr;
}
