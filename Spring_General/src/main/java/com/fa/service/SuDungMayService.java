package com.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.entities.SuDungMay;
import com.fa.repository.SuDungMayRepo;

@Service
@Transactional
public class SuDungMayService {

	@Autowired
	SuDungMayRepo repo;

	public void saveOrUpdate(SuDungMay obj) {
		repo.save(obj);
	}
}
