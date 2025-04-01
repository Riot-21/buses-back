package com.example.buses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.buses.model.MarcaBus;

public interface MarcaRepository extends JpaRepository<MarcaBus, Long>{

}
