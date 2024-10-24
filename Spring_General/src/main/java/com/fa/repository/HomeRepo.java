package com.fa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fa.entities.SuDungMay;

@Repository
public interface HomeRepo extends JpaRepository<SuDungMay, Integer> {

	@Query(value = "SELECT kh.ma_KH, kh.ten_KH, c.Ma_May, c.Vi_Tri, c.Trang_Thai, sdm.ngay_Bat_Dau, sdm.gio_Bat_Dau, sdm.thoi_Gian_Su_Dung, rdv.ma_DV, rdv.ngay_Su_Dung, rdv.gio_Su_Dung, rdv.so_Luong, rdv.don_Gia "
			+ "FROM dbo.SuDungMay sdm "
			+ "JOIN dbo.Computer c ON c.Ma_May = sdm.ma_May "
			+ "JOIN dbo.KhachHang kh ON kh.ma_KH = sdm.ma_KH "
			+ "LEFT JOIN (SELECT * FROM dbo.SuDungDichVu sddv "
			+ "JOIN dbo.DichVu dv ON dv.ma_DV = sddv.ma_DichVu) rdv ON rdv.ma_KH = kh.ma_KH ",
					countQuery = "SELECT COUNT (*) "
							+ "FROM dbo.SuDungMay sdm "
							+ "JOIN dbo.Computer c ON c.Ma_May = sdm.ma_May "
							+ "JOIN dbo.KhachHang kh ON kh.ma_KH = sdm.ma_KH "
							+ "LEFT JOIN (SELECT * FROM dbo.SuDungDichVu sddv "
							+ "JOIN dbo.DichVu dv ON dv.ma_DV = sddv.ma_DichVu) rdv ON rdv.ma_KH = kh.ma_KH "
	    	, nativeQuery = true)
	Page<Object[]> findAllData(Pageable pageable);
	
}
