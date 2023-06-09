package com.ec.diana.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.diana.dao.DetalleKardexDao;
import com.ec.diana.dao.KardexDao;
import com.ec.diana.entidad.DetalleKardex;
import com.ec.diana.mapper.DetalleKardexMapper;
import com.ec.diana.servicios.DetalleKardexRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@Api(value = "Diana", tags = "Diana", description = "Consulta el detalle de kardex")
public class DetalleKardexController {

	@Autowired
	private DetalleKardexRepository repository;

	@RequestMapping(value = "/detallekardex", method = RequestMethod.GET)
	public ResponseEntity<?> productos() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<DetalleKardex> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<DetalleKardex>) repository.findAll();
//			cfgPais = GlobalValue.LISTACFGPAIS;
			httpHeaders.add("STATUS", "1");
			return new ResponseEntity<List<DetalleKardexDao>>(DetalleKardexMapper.listaEntidadToListaDao(respuesta), httpHeaders, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<String>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value = "/detallekardex-id-kardex", method = RequestMethod.POST)
	public ResponseEntity<?> kardexporIdProducto(@RequestBody KardexDao valor) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<DetalleKardex> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta =  repository.buscarPorIdKardex(valor.getIdKardex());
//			cfgPais = GlobalValue.LISTACFGPAIS;
			httpHeaders.add("STATUS", "1");
			return new ResponseEntity<List<DetalleKardexDao>>(DetalleKardexMapper.listaEntidadToListaDao(respuesta), httpHeaders, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<String>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody DetalleKardexDao producto) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");

		try {
			DetalleKardex producto2 = repository.save(DetalleKardexMapper.daoToEntidad(producto));
			return new ResponseEntity<DetalleKardex>(producto2, httpHeaders, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<String>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
