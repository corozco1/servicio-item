package com.test.api.items.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.api.items.models.Producto;

@FeignClient(name = "servicio-productos", url="localhost:8001")
public interface ProductoClienteRest {

	@GetMapping("/listarProductos")
	public List<Producto> listarProductos();
	
	@GetMapping("/listar/{id}")  
    public Producto getProductoById(@PathVariable Long id);
	
}
