package com.test.api.items.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.items.models.Item;
import com.test.api.items.services.ItemServices;

@RestController
public class ItemController {
	
	@Autowired
    @Qualifier("serviceFeign")
	private ItemServices itemService;
	
	@GetMapping("/listarItems")
	public List<Item> listar(){
		return itemService.findAll();			
	}
	
	@GetMapping("/verItem/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
	return itemService.findById(id, cantidad);	
	}

}
