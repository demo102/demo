package com.example.schronisko.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.schronisko.model.Pies;

@Repository
public interface PiesRepository extends JpaRepository<Pies, Long> {

}
