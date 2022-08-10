package com.udemy.serviceproducto.models.service;

import com.udemy.serviceproducto.models.entity.Producto;

import java.util.List;

public interface IProductoService {
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public void delete(Long id);
    public List<Producto> findAll();
}
