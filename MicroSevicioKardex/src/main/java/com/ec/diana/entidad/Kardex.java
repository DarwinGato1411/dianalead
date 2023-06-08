package com.ec.diana.entidad;

import java.math.BigDecimal;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cabecera_kardex")
public class Kardex {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_kardex")
	private Integer idKardex;
	@Column(name = "kar_stock")
	private BigDecimal karStock;
	@Column(name = "id_producto")
	private Integer idProducto;


	public Kardex() {
		super();
	}


//	public Kardex(Integer idKardex, BigDecimal karStock, Integer idProducto) {
//		super();
//		this.idKardex = idKardex;
//		this.karStock = karStock;
//		this.idProducto = idProducto;
//	}


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
