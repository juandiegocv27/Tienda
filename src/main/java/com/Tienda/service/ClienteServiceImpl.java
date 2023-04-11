package com.Tienda.service;

import com.Tienda.dao.ArticuloDao;
import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import com.Tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Autowired
    ClienteDao creditoDao;

    @Autowired
    ArticuloDao ArticuloDao;

    @Override
    @Transactional(readOnly = true) //para manejar transacciones de solo lectura
    public List<Cliente> getCliente() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true) //para manejar transacciones de solo lectura
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) { //C
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);

        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
}
