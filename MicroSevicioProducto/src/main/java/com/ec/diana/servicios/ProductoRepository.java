package com.ec.diana.servicios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.diana.entidad.Producto;



/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

		
}
