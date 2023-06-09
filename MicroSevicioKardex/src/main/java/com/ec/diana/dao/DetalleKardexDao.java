package com.ec.diana.dao;

import java.math.BigDecimal;
import java.util.Date;

public class DetalleKardexDao {

	private Integer idDetalleKardex;
	private BigDecimal detkCantidad;
	private String detkTipo;
	private Date detkFecha;
	private Integer idKardex;

	public DetalleKardexDao() {
		super();
	}

	public Integer getIdDetalleKardex() {
		return idDetalleKardex;
	}

	public void setIdDetalleKardex(Integer idDetalleKardex) {
		this.idDetalleKardex = idDetalleKardex;
	}

	

	public BigDecimal getDetkCantidad() {
		return detkCantidad;
	}

	public void setDetkCantidad(BigDecimal detkCantidad) {
		this.detkCantidad = detkCantidad;
	}

	public String getDetkTipo() {
		return detkTipo;
	}

	public void setDetkTipo(String detkTipo) {
		this.detkTipo = detkTipo;
	}

	public Date getDetkFecha() {
		return detkFecha;
	}

	public void setDetkFecha(Date detkFecha) {
		this.detkFecha = detkFecha;
	}

	public Integer getIdKardex() {
		return idKardex;
	}

	public void setIdKardex(Integer idKardex) {
		this.idKardex = idKardex;
	}

}
