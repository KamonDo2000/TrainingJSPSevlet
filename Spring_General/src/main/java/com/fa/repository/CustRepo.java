package com.fa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fa.entities.KhachHang;

@Repository
public interface CustRepo extends JpaRepository<KhachHang, String> {
	Page<KhachHang> findAll(Pageable pageable);
	
	@Query("SELECT kh FROM KhachHang kh WHERE "
			+ "kh.tenKH LIKE %:searchKey% "
			+ "OR kh.diaChi LIKE %:searchKey% "
			+ "OR kh.soDienThoai LIKE %:searchKey% "
			+ "OR kh.diaChiEmail LIKE %:searchKey% ")
	Page<KhachHang> search(@Param("searchKey") String searchKey, Pageable pageable);
	
	@Query("SELECT kh.maKH FROM KhachHang kh")
	List<String> findAllMaKH();
	
	@Query(value = "SELECT DISTINCT kh.ma_KH FROM dbo.KhachHang kh JOIN dbo.SuDungMay sdm ON sdm.ma_KH = kh.ma_KH", nativeQuery = true)
	List<String> findAllMaKHDungMay();
}
