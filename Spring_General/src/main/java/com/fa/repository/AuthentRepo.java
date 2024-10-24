package com.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.entities.Authent;

@Repository
public interface AuthentRepo extends JpaRepository<Authent, String> {

}
