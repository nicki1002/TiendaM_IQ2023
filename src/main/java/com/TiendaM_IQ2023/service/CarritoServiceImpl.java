package com.TiendaM_IQ2023.service;

import com.TiendaM_IQ2023.dao.CarritoDao;
import com.TiendaM_IQ2023.domain.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    CarritoDao carritoDao;

    @Override
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    public Carrito getCarritoCliente(Long idCliente) {
        //Buscamos si existe el carrito para cliente
        Carrito carritoCliente = carritoDao.findByIdCliente(idCliente).orElse(null);

        // Si no eciste carrito, lo creamos
        if (carritoCliente == null) {
            Carrito carritoNuevo = new Carrito(idCliente);// idCarrito = 0, idCliente = 2
            carritoCliente = carritoDao.save(carritoNuevo); //idCarrito = 1, idCliente = 2
        }
        return carritoCliente;
    }

}
