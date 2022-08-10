package com.udemy.serviceproducto.controller;

import com.udemy.serviceproducto.models.entity.Producto;
import com.udemy.serviceproducto.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    @Autowired
    private Environment env;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> Listar(){

        return productoService.findAll().stream().map(producto -> {
            //producto.setPort(Integer.parseInt(env.getProperty("local.server.port"))); --Con Enviroment
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalleProducto(@PathVariable Long id){
        Producto producto = productoService.findById(id);
        //producto.setPort(Integer.parseInt(env.getProperty("local.server.port"))); --Con Enviroment
        producto.setPort(port);

        return producto;
    }
}
