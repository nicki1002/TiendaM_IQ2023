package com.TiendaM_IQ2023.dao;

import com.TiendaM_IQ2023.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {

    public List<Cliente> findByApellidos(String apellidos);

}
