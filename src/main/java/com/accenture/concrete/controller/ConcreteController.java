package com.accenture.concrete.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.SubCategoriaN2;
import com.accenture.concrete.service.impl.IConcreteService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** The Constant log. */
@RestController
@RequestMapping("/accenture")
@EnableSwagger2
public class ConcreteController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IConcreteService iConcreteService;

	@GetMapping(path = "/topCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubCategoriaN2>> getCategorias(
			@RequestHeader("X-Application-Name") String xApplicationName) {

		List<SubCategoriaN2> categories = iConcreteService.getTopCategorias();

		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping(path = "/otherCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubCategoriaN2>> getOtherCategorys(
			@RequestHeader("X-Application-Name") String xApplicationName) {

		List<SubCategoriaN2> categories = iConcreteService.getOthersCategorys();

		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping(path = "/getCouponsNoExp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Coupon>> getCupones(@RequestHeader("X-Application-Name") String xApplicationName) {

		List<Coupon> categories = iConcreteService.getCupones();

		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

}
