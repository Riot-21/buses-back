package com.example.buses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.buses.model.Bus;
import com.example.buses.services.BusService;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class BusController {
    private final BusService busService;

    @GetMapping()
    public ResponseEntity<Object> getAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        try{
            Page<Bus> buses = busService.getAll(page, size);
            return ResponseEntity.ok(buses);

        }catch(NoSuchElementException e){
            Map<String, String> response = new HashMap<>();
            response.put("message", "No se encontraron resultados");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBusById(@PathVariable Long id) {
    try {
        Bus bus = busService.getById(id);
        return ResponseEntity.ok(bus);  
    } catch (NoSuchElementException e) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "No se encontró bus con ID: "+id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    }  

}
