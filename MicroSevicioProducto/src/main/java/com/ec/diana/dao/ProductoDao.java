package com.ec.diana.dao;

public class ProductoDao {

	private String prodCodigo;
	private String prodNombre;	
	private Integer idProducto;
	
	
	
	public ProductoDao(String prodCodigo, String prodNombre) {
		super();
		this.prodCodigo = prodCodigo;
		this.prodNombre = prodNombre;
	}
	public ProductoDao() {
		super();
	}
	public String getProdCodigo() {
		return prodCodigo;
	}
	public void setProdCodigo(String prodCodigo) {
		this.prodCodigo = prodCodigo;
	}
	public String getProdNombre() {
		return prodNombre;
	}
	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	
	
}
