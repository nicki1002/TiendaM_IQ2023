
package com.TiendaM_IQ2023.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "carrito_detalle")
public class CarritoDetalle implements Serializable  {
  
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;
    private Long idCarrito;
    @JoinColumn(name="id_articulo", referencedColumnName ="id_articulo")
    @ManyToOne     
    private Articulo articulo;
    private double precio;
    private int cantidad;

    public CarritoDetalle() {
    }

    public CarritoDetalle(Long idCarrito, Articulo articulo, double precio, int cantidad) {
        this.idCarrito = idCarrito;
        this.articulo = articulo;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
}
