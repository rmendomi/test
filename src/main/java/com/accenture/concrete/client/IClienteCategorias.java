package com.accenture.concrete.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;

import com.accenture.concrete.domain.Categories;

import lombok.extern.slf4j.Slf4j;

public interface IClienteCategorias {

	List<Categories> getCategorias();

	void clearCacheSchedule();

}
