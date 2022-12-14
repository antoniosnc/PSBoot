package com.udemy.serviceitemp.models.service;

import com.udemy.serviceitemp.models.Item;
import com.udemy.serviceitemp.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("itemServiceRest")
public class ItemServiceImpl implements IItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://spring-boot-producto/listar", Producto[].class));

        return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, int cantidad) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());

        Producto producto = clienteRest.getForObject("http://spring-boot-producto/ver/{id}", Producto.class, pathVariables);

        return new Item(producto, cantidad);
    }
}
