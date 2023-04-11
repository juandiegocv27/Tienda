
package com.Tienda.controller;

import com.Tienda.domain.Articulo;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticuloController {

    @Autowired
    ArticuloService articuloService;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulo(false);           
        model.addAttribute("articulos", articulos);

        return "/articulo/listado";
    }

    @GetMapping("/Articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategoria(true);                         
        model.addAttribute("categorias", categorias);
        return "/Articulo/modificar";
    }

    @PostMapping("/Articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/Articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategoria(true);       
        model.addAttribute("categorias", categorias);
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/Articulo/modificar";
    }

    @GetMapping("/Articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
}