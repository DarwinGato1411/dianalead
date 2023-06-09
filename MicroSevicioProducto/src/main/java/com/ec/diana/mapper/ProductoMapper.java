package com.ec.diana.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.diana.dao.ProductoDao;
import com.ec.diana.entidad.Producto;
import com.ec.diana.servicios.ProductoRepository;

public class ProductoMapper {
	
	public static ProductoDao entidadToDao(Producto valor) {
		ProductoDao dao = new ProductoDao();
		dao.setIdProducto(valor.getIdProducto());
		dao.setProdCodigo(valor.getProdCodigo());
		dao.setProdNombre(valor.getProdNombre());
		return dao;
	}

	public static Producto daoToEntidad(ProductoDao valor) {
		Producto producto = new Producto();	
		producto.setIdProducto(valor.getIdProducto());
		if (valor.getProdCodigo() != null)
			producto.setProdCodigo(valor.getProdCodigo());
		if (valor.getProdNombre() != null)
			producto.setProdNombre(valor.getProdNombre());
		producto.setProdFechaCreacion(new Date());
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
