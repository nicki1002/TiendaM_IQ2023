
package com.TiendaM_IQ2023.service;

import com.TiendaM_IQ2023.domain.Carrito;

public interface CarritoService {
    
    public Carrito getCarrito(Carrito carrito);
    
    public Carrito getCarritoCliente(Long idCliente);
    
}
