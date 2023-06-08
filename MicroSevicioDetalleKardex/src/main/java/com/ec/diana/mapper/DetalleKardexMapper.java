package com.ec.diana.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ec.diana.dao.DetalleKardexDao;
import com.ec.diana.entidad.DetalleKardex;

public class DetalleKardexMapper {

	public static DetalleKardexDao entidadToDao(DetalleKardex valor) {
		DetalleKardexDao dao = new DetalleKardexDao();
		dao.setIdDetalleKardex(valor.getIdDetalleKardex());
		dao.setIdKardex(valor.getIdKardex());
		dao.setDetkCantidad(valor.getDetkCantidad());
		dao.setDetkFecha(valor.getDetkFecha());
		dao.setDetkTipo(valor.getDetkTipo());
		return dao;
	}

	public static DetalleKardex daoToEntidad(DetalleKardexDao valor) {
		DetalleKardex producto = new DetalleKardex();
		producto.setIdDetalleKardex(valor.getIdDetalleKardex());
		producto.setIdKardex(valor.getIdKardex());
		producto.setDetkCantidad(valor.getDetkCantidad());
		producto.setDetkFecha(valor.getDetkFecha());
		producto.setDetkTipo(valor.getDetkTipo());
		return producto;
	}

	public static List<DetalleKardexDao> listaEntidadToListaDao(List<DetalleKardex> valor) {
		List<DetalleKardexDao> listdDaos = new ArrayList<>();
		for (DetalleKardex producto : valor) {
			listdDaos.add(entidadToDao(producto));
		}
		return listdDaos;
	}
}
