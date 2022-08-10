package com.udemy.serviceitemp.models.service;

import com.udemy.serviceitemp.models.Item;
import java.util.List;

public interface IItemService {

    public List<Item> findAll();

    public Item findById(Long id, int cantidad);
}
