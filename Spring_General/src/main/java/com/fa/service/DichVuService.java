package com.fa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.entities.DichVu;
import com.fa.repository.DichVuRepo;

@Service
@Transactional
public class DichVuService {

	@Autowired
	DichVuRepo repo;
	
	public Page<DichVu> getAllData(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	public Page<DichVu> search(String searchKey, Pageable pageable) {
		return repo.search(searchKey, pageable);
	}
	
	public void saveOrUpdate(DichVu obj) {
		repo.save(obj);
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}
	
	public List<String> findAllMaDV() {
		return repo.findAllMaDV();
	}
	
	public DichVu findByID(String id) {
		return repo.findById(id).orElse(null);
	}
	
	public boolean checkDuplicate(String id) {
		for (String e : repo.findAllMaDV()) {
			if (e.equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}
	
}
