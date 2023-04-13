
package com.TiendaM_IQ2023.dao;

import com.TiendaM_IQ2023.domain.Articulo;
import com.TiendaM_IQ2023.domain.CarritoDetalle;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long>{
  
    List<CarritoDetalle> findByIdCarrito(Long idCarrito);
    
    CarritoDetalle findByIdCarritoAndArticulo(Long idCarrito, Articulo articulo);
    
    void deleteByIdCarrito(Long idCarrito);
}
