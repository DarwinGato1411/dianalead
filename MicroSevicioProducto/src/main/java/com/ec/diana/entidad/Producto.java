package com.ec.diana.entidad;


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
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_producto")
	private Integer idProducto;
	@Column(name = "prod_codigo")
	private String prodCodigo;
	@Column(name = "prod_nombre")
	private String prodNombre;
	@Column(name = "prod_fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date prodFechaCreacion;
	
	public Producto() {
		super();
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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

	public Date getProdFechaCreacion() {
		return prodFechaCreacion;
	}

	public void setProdFechaCreacion(Date prodFechaCreacion) {
		this.prodFechaCreacion = prodFechaCreacion;
	}

	

}
