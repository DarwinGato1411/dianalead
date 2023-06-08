package com.ec.diana.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ec.diana.dao.KardexDao;
import com.ec.diana.entidad.Kardex;

public class KardexMapper {

	public static KardexDao entidadToDao(Kardex valor) {
		KardexDao dao = new KardexDao();
	
			dao.setIdKardex(valor.getIdKardex());
		
		dao.setIdProducto(valor.getIdProducto());
		
		dao.setKarStock(valor.getKarStock());
		return dao;
	}

	public static Kardex daoToEntidad(KardexDao valor) {
		Kardex entidad = new Kardex();
		if(	valor.getIdKardex()!=null) {
			entidad.setIdKardex(valor.getIdKardex());
		}
		entidad.setIdProducto(valor.getIdProducto());
	
		entidad.setKarStock(valor.getKarStock());
		return entidad;
	}

	public static List<KardexDao> listaEntidadToListaDao(List<Kardex> valor) {
		List<KardexDao> listdDaos = new ArrayList<>();
		for (Kardex item : valor) {
			listdDaos.add(entidadToDao(item));
		}
		return listdDaos;
	}
}
