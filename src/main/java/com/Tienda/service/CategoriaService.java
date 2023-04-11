package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategoria(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria); //para insertar para modificar un registro

    public void delete(Categoria categoria);

}
