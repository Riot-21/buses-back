package com.example.buses.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.buses.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {

        Page<Bus> findByActivoTrue(Pageable pageable);

        Optional<Bus> findByIdAndActivoTrue(Long id);
}
