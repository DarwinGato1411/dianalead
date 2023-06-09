package com.ec.diana.entidad;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "detalle_kardex")
public class DetalleKardex {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_detalle_kardex")
	private Integer idDetalleKardex;
	@Column(name = "detk_cantidad")
	private BigDecimal detkCantidad;
	@Column(name = "detk_tipo")
	private String detkTipo;
	@Column(name = "detk_fecha")
	@Temporal(TemporalType.DATE)
	private Date detkFecha;
	@Column(name = "id_kardex")
	private Integer idKardex;

	public DetalleKardex() {
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
