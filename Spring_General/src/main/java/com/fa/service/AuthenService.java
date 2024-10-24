package com.fa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.entities.Authent;
import com.fa.repository.AuthentRepo;

@Service
@Transactional
public class AuthenService {

	@Autowired
	AuthentRepo repo;

	public boolean checkAuthent(Authent aut) {
		List<Authent> listAut = repo.findAll();
		for (Authent auth : listAut) {
			if (auth.getUserName().equals(aut.getUserName()) && auth.getPassWorld().equals(aut.getPassWorld())) {
				return true;
			}
		}
		return false;
	}

}
