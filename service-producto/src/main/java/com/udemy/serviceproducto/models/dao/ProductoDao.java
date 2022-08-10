package com.udemy.serviceproducto.models.dao;

import com.udemy.serviceproducto.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
