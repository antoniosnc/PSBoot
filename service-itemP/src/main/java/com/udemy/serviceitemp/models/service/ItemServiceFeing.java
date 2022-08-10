package com.udemy.serviceitemp.models.service;

import com.udemy.serviceitemp.clientes.ProductoClienteRest;
import com.udemy.serviceitemp.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("itemServiceFeing")
//@Primary --Si es por nombre ya no es necesario
public class ItemServiceFeing implements IItemService {

    @Autowired
    private ProductoClienteRest productoClienteFeign;

    @Override
    public List<Item> findAll() {
        return productoClienteFeign.Listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, int cantidad) {
        return new Item(productoClienteFeign.detalleProducto(id), cantidad);
    }
}
