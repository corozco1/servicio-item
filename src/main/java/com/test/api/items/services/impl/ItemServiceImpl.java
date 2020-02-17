package com.test.api.items.services.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.api.items.models.Item;
import com.test.api.items.models.Producto;
import com.test.api.items.services.ItemServices;

@Service("serviceRestClient")
public class ItemServiceImpl implements ItemServices {

	@Autowired
    private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		
		List<Producto>  productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listarProductos", Producto[].class));	
		return  productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://servicio-productos/listar/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
