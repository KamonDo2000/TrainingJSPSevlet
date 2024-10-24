package com.fa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.entities.Computer;
import com.fa.repository.CompRepo;

@Service
@Transactional
public class CompService {

	@Autowired
	CompRepo repo;

	public Page<Computer> getAllData(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void saveComp(Computer comp) {
		repo.save(comp);
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}

	public Page<Computer> search(String searchKey, Pageable pageable) {
		return repo.search(searchKey, pageable);
	}

	public List<String> findAllMaMay() {
		return repo.findAllMaMay();
	}

	public Computer findByID(int id) {
		return repo.findById(id).orElse(null);
	}
	
}
