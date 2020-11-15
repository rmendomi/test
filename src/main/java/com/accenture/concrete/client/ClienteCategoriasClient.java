package com.accenture.concrete.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.accenture.concrete.domain.Categories;
import com.accenture.concrete.domain.CategoryThree;

import lombok.extern.slf4j.Slf4j;

/**
 * Categorias
 */
@Slf4j
@Service
public class ClienteCategoriasClient implements IClienteCategorias {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${client.url.service.categorias}")
	private String url;

	public List<Categories> getCategorias() {

		HttpEntity<String> request = new HttpEntity<>(null);
		ResponseEntity<CategoryThree> entity = new ResponseEntity<>(HttpStatus.OK);
		try {
			entity = restTemplate.exchange(url, HttpMethod.GET, request, CategoryThree.class);

		} catch (RestClientException e) {
			log.error("Error : ", e);
		}
		return entity.getBody().getSubcategories();

	}

}
