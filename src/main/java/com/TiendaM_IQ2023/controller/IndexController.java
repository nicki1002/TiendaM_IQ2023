
package com.TiendaM_IQ2023.controller;

import com.TiendaM_IQ2023.domain.Cliente;
import com.TiendaM_IQ2023.dao.ClienteDao;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model) {
//       log.info( "Ahora desde MVC");
//       model.addAttribute("Mensaje", "Hola desde el controllador");
//      
//      Cliente cliente =new Cliente("Nicole","Hernandez Torres","nicki@gmail.com","85241578");
//    model.addAttribute("objectoCliente", cliente);    
//    
//    Cliente cliente2 =new Cliente("Nina","Hernandez Torres","nicki@gmail.com","85241578");
//    Cliente cliente3 =new Cliente("Haydee","Hernandez Torres","nicki@gmail.com","85241578");
//     
//   
//    List<Cliente> clientes = Arrays.asList(cliente, cliente2, cliente3);

       var clientes = clienteDao.findAll();
       model.addAttribute("clientes", clientes);
       
        return "index";
    }
    
}
