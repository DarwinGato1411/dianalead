package com.ec.diana.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ec.diana.entidad.Kardex;




/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KardexRepository extends CrudRepository<Kardex, Long> {

	@Query("SELECT u FROM Kardex u WHERE  u.idProducto =:idProducto  ")
	Kardex buscarPorIdProducto(@Param("idProducto") Integer idProducto);
	
	@Query("SELECT u FROM Kardex u WHERE  u.idKardex =:idKardex  ")
	Kardex buscarPorIdKardex(@Param("idKardex") Integer idKardex);
}
