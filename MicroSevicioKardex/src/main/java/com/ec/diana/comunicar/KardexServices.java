package com.ec.diana.comunicar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ec.diana.dao.DetalleKardexDao;
import com.ec.diana.dao.KardexDao;

@Service
public class KardexServices {

	@Autowired
    RestTemplate restTemplate;
	
	public List<DetalleKardexDao> getDetalleKardex(Integer idKardex){
		
		List<DetalleKardexDao> detalleKardex= restTemplate.getForObject("http://localhost:8587/api/detallekardex-id-kardex/" + idKardex, List.class);
        return detalleKardex;
	}
	
	
	
}
