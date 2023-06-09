package com.ec.diana.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.diana.dao.KardexDao;
import com.ec.diana.dao.ProductoDao;
import com.ec.diana.entidad.Kardex;
import com.ec.diana.mapper.KardexMapper;
import com.ec.diana.servicios.KardexRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@Api(value = "Diana", tags = "Diana", description = "Micro servicio Kardex")
public class KardexController {

	@Autowired
	private KardexRepository repository;
	
	

	@RequestMapping(value = "/kardex", method = RequestMethod.GET)
	public ResponseEntity<?> productos() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Kardex> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Kardex>) repository.findAll();
//			cfgPais = GlobalValue.LISTACFGPAIS;
			httpHeaders.add("STATUS", "1");
			return new ResponseEntity<List<KardexDao>>(KardexMapper.listaEntidadToListaDao(respuesta), httpHeaders, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<String>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
//	@RequestMapping(value = "/kardex-id-producto", method = RequestMethod.POST)
	@GetMapping("/kardex-id-producto/{kardexId}")
	public ResponseEntity<?> kardexporIdProducto(@PathVariable("kardexId") int kardexId) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		Kardex respuesta = new Kardex();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta =  repository.buscarPorIdProducto(kardexId);
//			cfgPais = GlobalValue.LISTACFGPAIS;
			httpHeaders.add("STATUS", "1");
			return new ResponseEntity<KardexDao>(KardexMapper.entidadToDao(respuesta), httpHeaders, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<String>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody KardexDao valor) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");

		try {
			Kardex producto2 = repository.save(KardexMapper.daoToEntidad(valor));
			return new ResponseEntity<Kardex>(producto2, httpHeaders, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<String>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

}
