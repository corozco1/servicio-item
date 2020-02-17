package com.test.api.items.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Producto {

	@Id
	private ObjectId _id;
	private Long id;
	private String nombre;
	private Double precio;
	
	public ObjectId get_id() {
		return _id;
	} 
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
}
