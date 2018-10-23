package com.example.demo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo2.model.Klient;

@Repository
public interface KlientRepository extends JpaRepository<Klient, Long> {

	Klient findByNazwisko(String nazwisko);
}
