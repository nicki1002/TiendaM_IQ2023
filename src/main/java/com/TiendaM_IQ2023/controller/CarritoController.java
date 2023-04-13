
package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.domain.Articulo;
import com.TiendaM_IQ2023.domain.CarritoDetalle;
import com.TiendaM_IQ2023.service.ArticuloService;
import com.TiendaM_IQ2023.service.CarritoDetalleService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CarritoController {
    
   @Autowired
   CarritoDetalleService carritoDetalleService;
   
   @Autowired
   ArticuloService articuloService;
    
   @GetMapping("/carrito/agregar/{idArticulo}")
   public String agregar(Articulo articulo, HttpSession session){
       Long idCarrito = (Long)session.getAttribute("idCarrito");
   articulo = articuloService.getArticulo(articulo);
   
   CarritoDetalle carritoDetalle = carritoDetalleService.getCarritoDetalle(idCarrito, articulo);
   if(carritoDetalle != null){
       carritoDetalle.setCantidad(carritoDetalle.getCantidad()+1);
    }else{
       carritoDetalle = new CarritoDetalle(idCarrito, articulo, articulo.getPrecio(),1);
   }
   carritoDetalleService.save(carritoDetalle);
   
   return "redirect:/";
   }
   
   @GetMapping("/carrito/listado")
   public String listado(Model model, HttpSession session){
       Long idCarrito = (Long)session.getAttribute("idCarrito");
       boolean esCliente = (boolean)session.getAttribute("esCliente");
       
       List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(idCarrito);
        
        double montoTotal = 0.0;
        double montoImpuestos = 0.0;
        
        for(CarritoDetalle c: carritoDetalles){
            montoTotal += c.getPrecio() * c.getCantidad();
        }
        
        montoImpuestos = montoTotal * 0.15;
        
        model.addAttribute("carrtoDetalles", carritoDetalles);
        model.addAttribute("cantidadArticulosCarrito", carritoDetalles.size());
        model.addAttribute("esCliente",esCliente);
        model.addAttribute("montoImpuestos", montoImpuestos);
        model.addAttribute("montoTotal", montoTotal);
        
        return "/carrito/listado";        
   }
   
   @GetMapping("/carrito/eliminar/{idDetalle}")
   public String eliminar(CarritoDetalle carritoDetalle){
       carritoDetalleService.delete(carritoDetalle);
       
       return "redirect:/carrito/listado";
   }
}
