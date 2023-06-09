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

import com.ec.diana.comunicar.ProductoServices;
import com.ec.diana.dao.DetalleKardexDao;
import com.ec.diana.dao.KardexDao;
import com.ec.diana.dao.ProductoDao;
import com.ec.diana.entidad.Producto;
import com.ec.diana.mapper.ProductoMapper;
import com.ec.diana.servicios.ProductoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@Api(value = "Diana", tags = "Diana", description = "Consulta de productos")
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	ProductoServices productoServices;

	@RequestMapping(value = "/producto", method = RequestMethod.GET)
	@ApiOperation(value = "Consulta todos los producto", tags = "Producto")
	public ResponseEntity<?> productos() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Producto> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Producto>) productoRepository.findAll();
//			cfgPais = GlobalValue.LISTACFGPAIS;
			httpHeaders.add("STATUS", "1");
			return new ResponseEntity<List<ProductoDao>>(ProductoMapper.listaEntidadToListaDao(respuesta), httpHeaders,
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<String>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ApiOperation(value = "Guarda un producto", tags = "Producto")
	public ResponseEntity<?> save(@RequestBody ProductoDao producto) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");

		try {
			Producto productow = productoRepository.buscarPorIdProducto(producto.getIdProducto());

			Producto producto2 = productoRepository.save(ProductoMapper.daoToEntidad(producto));
//			Optional<Producto> so=productoRepository.findById(1);
//			so.isPresent()
			return new ResponseEntity<Producto>(producto2, httpHeaders, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<String>(e.getMessage(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* COMUNICACION ENTRE MICROSERVICIOS */
	@GetMapping("/producto/kardex/{idProducto}")
	public ResponseEntity<?> getKardex(@PathVariable("idProducto") int idProducto) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");

		KardexDao kardex = productoServices.getKardexPorIdProducto(idProducto);
		if (kardex == null)
			return ResponseEntity.notFound().build();
		return new ResponseEntity<KardexDao>(kardex, httpHeaders, HttpStatus.OK);
	}

	@GetMapping("/producto/detalle-kardex/{idProducto}")
	public ResponseEntity<?> getDetalleKardex(@PathVariable("idProducto") int idProducto) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");

		KardexDao kardex = productoServices.getKardexPorIdProducto(idProducto);
		if (kardex == null)
			return ResponseEntity.notFound().build();
		List<DetalleKardexDao> detalle = productoServices.getDetalleKardex(kardex.getIdKardex());
//        return ResponseEntity.ok(bikes);
		return new ResponseEntity<List<DetalleKardexDao>>(detalle, httpHeaders, HttpStatus.OK);
	}
}
