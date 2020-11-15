/*
 * 
 */
package com.accenture.concrete.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.concrete.client.IClienteCategorias;
import com.accenture.concrete.client.IClienteCupones;
import com.accenture.concrete.domain.Categories;
import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.SubCategoriaN2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConcreteServiceImpl implements IConcreteService {

	@Autowired
	private IClienteCategorias iClienteCategorias;
	@Autowired
	private IClienteCupones iClienteCupones;

	@Override
	public List<SubCategoriaN2> getTopCategorias() {

		List<Categories> categorias = iClienteCategorias.getCategorias();
		List<SubCategoriaN2> cat2 = new ArrayList<>();

		for (Categories categories : categorias) {
			cat2 = categories.getSubcategories();
		}

		List<SubCategoriaN2> sortedList = cat2.stream().sorted(Comparator.comparingInt(SubCategoriaN2::getRelevance))
				.collect(Collectors.toList());
		List<SubCategoriaN2> myLastPosts = sortedList.subList(sortedList.size() - 5, sortedList.size());

		log.info("---------------------------------------------------");
		for (SubCategoriaN2 x1 : myLastPosts) {
			log.info("Retorno servicio: {}", x1.toString());
		}

		// TODO: falta dar vuelta los registros enviados(de bonito).
		return myLastPosts;
	}

	@Override
	public List<Coupon> getCupones() {
		List<Coupon> cupones = iClienteCupones.getCupones();
		List<Coupon> returnCoupones = new ArrayList<>();
		Date today = new Date();
		for (Coupon x1 : cupones) {
			try {
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(x1.getExpiresAt());
				if (today.before(date1)) {
					returnCoupones.add(x1);
				}
			} catch (ParseException e) {
				log.error("Exception ParseException", e);
			}
			log.info("Retorno servicio: {}", returnCoupones.toString());
		}
		return returnCoupones;
	}

	@Override
	public List<SubCategoriaN2> getOthersCategorys() {

		List<Categories> categorias = iClienteCategorias.getCategorias();
		List<SubCategoriaN2> onlySubcategory = new ArrayList<>();

		for (Categories categories : categorias) {
			if (onlySubcategory.isEmpty()) {
				onlySubcategory.addAll(categories.getSubcategories());
			}
		}

		List<SubCategoriaN2> rest = getTopCategorias();
		onlySubcategory.removeAll(rest);

		return onlySubcategory;
	}

}