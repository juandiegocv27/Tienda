package com.Tienda.service;

import com.Tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulo(boolean activos);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo); //para insertar para modificar un registro

    public void delete(Articulo articulo);

}
