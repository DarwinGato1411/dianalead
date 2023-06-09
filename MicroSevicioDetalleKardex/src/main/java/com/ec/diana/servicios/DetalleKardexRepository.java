package com.ec.diana.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ec.diana.entidad.DetalleKardex;




/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DetalleKardexRepository extends CrudRepository<DetalleKardex, Long> {
	@Query("SELECT u FROM DetalleKardex u WHERE  u.idKardex =:idKardex  ")
	List<DetalleKardex> buscarPorIdKardex(@Param("idKardex") Integer idKardex);
}
