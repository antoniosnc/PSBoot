package com.udemy.serviceproducto.models.service;
import com.udemy.serviceproducto.models.dao.ProductoDao;
import com.udemy.serviceproducto.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

   @Autowired
   private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public void delete(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }
}

