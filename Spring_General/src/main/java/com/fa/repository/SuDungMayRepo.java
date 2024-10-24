package com.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.entities.SuDungMay;
import com.fa.entities.SuDungMayID;

@Repository
public interface SuDungMayRepo extends JpaRepository<SuDungMay, SuDungMayID> {
	
}
