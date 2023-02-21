package com.Tienda.controller;


import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteService ClienteService;
    
    @GetMapping("/")
    public String Inicio(Model model) {
        log.info("Ahora utilizando MCV");

        var clientes = ClienteService.getCliente();
        model.addAttribute("clientes", clientes);

        return "index";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente)  {
        ClienteService.save(cliente);
        return"index";
    }
    
}
