package com.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.entities.SuDungDichVu;
import com.fa.entities.SuDungDichVuID;

@Repository
public interface SuDungDichVuRepo extends JpaRepository<SuDungDichVu, SuDungDichVuID> {

}
