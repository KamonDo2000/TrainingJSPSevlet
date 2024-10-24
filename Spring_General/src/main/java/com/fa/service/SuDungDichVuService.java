package com.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.entities.SuDungDichVu;
import com.fa.repository.SuDungDichVuRepo;

@Service
@Transactional
public class SuDungDichVuService {

	@Autowired
	SuDungDichVuRepo repo;

	public void saveOrUpdate(SuDungDichVu obj) {
		repo.save(obj);
	}

}
