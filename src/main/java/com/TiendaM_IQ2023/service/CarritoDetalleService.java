
package com.TiendaM_IQ2023.service;

import com.TiendaM_IQ2023.domain.Articulo;
import com.TiendaM_IQ2023.domain.CarritoDetalle;
import java.util.List;


public interface CarritoDetalleService {
 
    public CarritoDetalle getCarritoDetalle(Long idCarrito, Articulo articulo);
    
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito);
    
    public void save(CarritoDetalle carritoDetalle);
    
    public void delete(CarritoDetalle carritoDetalle);
      
     public void deleteAll(Long idCarrito);
}
