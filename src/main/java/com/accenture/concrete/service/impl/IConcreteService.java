package com.accenture.concrete.service.impl;

import java.util.List;

import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.SubCategoriaN2;

public interface IConcreteService {

	List<SubCategoriaN2> getTopCategorias();

	List<SubCategoriaN2> getOthersCategorys();

	List<Coupon> getCupones();

}
