package com.udemy.serviceitemp.controllers;

import com.udemy.serviceitemp.models.Item;
import com.udemy.serviceitemp.models.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired

    //@Qualifier("itemServiceFeing")   //Para feing
    @Qualifier("itemServiceRest")      //Para Ribbon
    private IItemService iItemService;

    @GetMapping("/listar")
    public List<Item> listar(){
        return iItemService.findAll();
    }

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable int cantidad){
        return iItemService.findById(id, cantidad);
    }
}
