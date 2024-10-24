package com.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.repository.HomeRepo;

@Service
@Transactional
public class HomeService {

	@Autowired
	HomeRepo repo;

	public Page<Object[]> getAllData(Pageable pageable) {
		return repo.findAllData(pageable);
	}

}
