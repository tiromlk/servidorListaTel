package com.lista.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lista.model.Contato;

/**
 * Created by ceb on 30/04/16.
 */
public interface ContatoRepository extends JpaRepository<Contato, Long> {

	Contato findById(Long id);
	
	Contato deleteById(Long id);
	
	List<Contato> findAll();
}