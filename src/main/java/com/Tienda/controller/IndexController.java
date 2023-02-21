package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Juan Diego-PC
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteDao clienteDao;
    
    @GetMapping("/hola")
    public String Inicio(Model model) {
        log.info("Ahora utilizando MCV");
        String mensaje = "Estamos en semana 4, saludos!";
        model.addAttribute("MensajeSaludos", mensaje);

//        Cliente cliente = new Cliente("Juan Diego", "Carballo Villalobos", "juandiegocarballo2701@gmail.com", "89141363");
//        Cliente cliente2 = new Cliente("Luis Diego", "Salazar Hernandez", "Pedritonavajas3401@gmail.com", "87123941");
//        Cliente cliente3 = new Cliente("Rita María", "Villalobos Ruiz", "rita1268@gmail.com", "83525228");
//        //model.addAttribute("cliente", cliente);
//
//        List<Cliente> clientes = Arrays.asList(cliente, cliente2, cliente3);
//        model.addAttribute("clientes", clientes);
        //model.addAttribute(clientes);

        var clientes = clienteDao.findAll();
         model.addAttribute("clientes", clientes);
         
        return "index";
    }

}
