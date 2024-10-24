package com.fa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.entities.KhachHang;
import com.fa.repository.CustRepo;

@Service
@Transactional
public class CustService {

	@Autowired
	CustRepo repo;

	public Page<KhachHang> getAllData(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	public Page<KhachHang> search(String searchKey, Pageable pageable) {
		return repo.search(searchKey, pageable);
	}
	
	public void saveOrUpdate(KhachHang obj) {
		repo.save(obj);
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}
	
	public List<String> findAllMaKH() {
		return repo.findAllMaKH();
	}
	
	public List<String> findAllMaKHDungMay() {
		return repo.findAllMaKHDungMay();
	}
	
	
	public KhachHang findByID(String id) {
		return repo.findById(id).orElse(null);
	}
	
	public boolean checkDuplicate(String id) {
		for (String e : repo.findAllMaKH()) {
			if (e.equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}
	
}
