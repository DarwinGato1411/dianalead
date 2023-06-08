package com.ec.diana.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ec.diana.dao.ProductoDao;
import com.ec.diana.entidad.Producto;

public class ProductoMapper {

	public static ProductoDao entidadToDao(Producto valor) {
		ProductoDao dao = new ProductoDao();
		dao.setProdCodigo(valor.getProdCodigo());
		dao.setProdNombre(valor.getProdNombre());
		return dao;
	}

	public static Producto daoToEntidad(ProductoDao valor) {
		Producto producto = new Producto();
		producto.setProdCodigo(valor.getProdCodigo());
		producto.setProdNombre(valor.getProdNombre());
		return producto;
	}

	public static List<ProductoDao> listaEntidadToListaDao(List<Producto> valor) {
		List<ProductoDao> listdDaos = new ArrayList<>();
		for (Producto producto : valor) {
			listdDaos.add(entidadToDao(producto));
		}
		return listdDaos;
	}
}
