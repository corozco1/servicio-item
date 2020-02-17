package com.test.api.items.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.test.api.items.clientes.ProductoClienteRest;
import com.test.api.items.models.Item;
import com.test.api.items.services.ItemServices;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemServices {
	
	@Autowired
	private ProductoClienteRest clienteFeign; 

	@Override
	public List<Item> findAll() {		
		return clienteFeign.listarProductos().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
