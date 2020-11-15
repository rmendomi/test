package com.accenture.concrete.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.accenture.concrete.domain.Coupon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteCuponesClient implements IClienteCupones {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${client.url.service.cupones}")
	private String url;

	/**
	 * Cupones
	 *
	 */
	public List<Coupon> getCupones() {

		ResponseEntity<List<Coupon>> retornoCoupon = new ResponseEntity<>(HttpStatus.OK);
		try {
			retornoCoupon = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Coupon>>() {
					});

		} catch (RestClientException e) {
			log.error("Error : ", e);
		}
		return retornoCoupon.getBody();
	}

}
