package com.ec.diana.dao;

import java.math.BigDecimal;

public class KardexDao {

	private Integer idKardex;
	private BigDecimal karStock;
	private Integer idProducto;
	
	
	
	
	public KardexDao() {
		super();
	}




	public KardexDao(Integer idKardex, BigDecimal karStock, Integer idProducto) {
		super();
		this.idKardex = idKardex;
		this.karStock = karStock;
		this.idProducto = idProducto;
	}




	public Integer getIdKardex() {
		return idKardex;
	}




	public void setIdKardex(Integer idKardex) {
		this.idKardex = idKardex;
	}




	public BigDecimal getKarStock() {
		return karStock;
	}




	public void setKarStock(BigDecimal karStock) {
		this.karStock = karStock;
	}




	public Integer getIdProducto() {
		return idProducto;
	}




	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}


	
	
	
	
	
	
}
