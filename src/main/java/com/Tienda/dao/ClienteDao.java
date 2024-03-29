package com.Tienda.dao;

import com.Tienda.domain.Cliente;
import com.Tienda.domain.Credito;
import org.springframework.data.repository.CrudRepository;



public interface ClienteDao extends CrudRepository<Cliente, Long>{

    public Credito save(Credito credito);
    
}
