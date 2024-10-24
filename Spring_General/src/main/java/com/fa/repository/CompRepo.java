package com.fa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fa.entities.Computer;

@Repository
public interface CompRepo extends JpaRepository<Computer, Integer> {
	Page<Computer> findAll(Pageable pageable);

	@Query("SELECT m FROM Computer m WHERE " + "m.trangThai LIKE %:searchKey% " + "OR m.viTri LIKE %:searchKey% ")
	Page<Computer> search(@Param("searchKey") String searchKey, Pageable pageable);

	@Query("SELECT m.maMay FROM Computer m")
	List<String> findAllMaMay();
}
