package com.test.api.items.services;

import java.util.List;

import com.test.api.items.models.Item;

public interface ItemServices {

	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);
	
}
