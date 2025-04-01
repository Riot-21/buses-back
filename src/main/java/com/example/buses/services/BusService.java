package com.example.buses.services;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.buses.model.Bus;
import com.example.buses.repositories.BusRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;

    @Transactional( readOnly =true)
    public Page<Bus> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Bus> busPage = busRepository.findByActivoTrue(pageable);

        if (busPage.isEmpty()) {
            throw new NoSuchElementException("No se encontraron buses en la página " + page);
        }

        return busPage;
    }

    @Transactional(readOnly = true)
    public Bus getById(Long id){
        return busRepository.findByIdAndActivoTrue(id)
            .orElseThrow(() -> new NoSuchElementException("Bus no encontrado con ID: "+ id));
    }

}
