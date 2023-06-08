package com.ec.diana.servicios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.diana.entidad.Kardex;



/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KardexRepository extends CrudRepository<Kardex, Long> {

		
}
