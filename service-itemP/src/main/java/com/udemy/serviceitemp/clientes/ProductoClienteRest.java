package com.udemy.serviceitemp.clientes;

import com.udemy.serviceitemp.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Prueba
@FeignClient(name = "spring-boot-producto")
public interface ProductoClienteRest {
    @GetMapping("/listar")
    public List<Producto> Listar();

    @GetMapping("/ver/{id}")
    public Producto detalleProducto(@PathVariable Long id) ;
}
