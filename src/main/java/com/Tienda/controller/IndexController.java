/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    ClienteService clienteService;

      @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC");

        var clientes = clienteService.getCliente();
        model.addAttribute("clientes", clientes);

        return "index";
    }
}
