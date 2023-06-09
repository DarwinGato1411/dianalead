package com.ec.diana.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ec.diana.entidad.Producto;

/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

	@Query("SELECT u FROM Producto u WHERE  u.idProducto =:idProducto  ")
	Producto buscarPorIdProducto(@Param("idProducto") Integer idProducto);
	List<Producto> findByProdNombre(String prodNombre);
	Producto findByProdCodigo(String prodCodigo);

}
