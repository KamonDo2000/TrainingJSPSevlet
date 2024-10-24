package com.fa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fa.entities.DichVu;

@Repository
public interface DichVuRepo extends JpaRepository<DichVu, String> {
	Page<DichVu> findAll(Pageable pageable);
	
	@Query("SELECT dv FROM DichVu dv WHERE "
			+ "dv.tenDV LIKE %:searchKey% "
			+ "OR dv.donViTinh LIKE %:searchKey% "
			+ "OR dv.donGia LIKE %:searchKey% ")
	Page<DichVu> search(@Param("searchKey") String searchKey, Pageable pageable);
	
	@Query("SELECT dv.maDV FROM DichVu dv")
	List<String> findAllMaDV();
}
