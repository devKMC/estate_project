package com.estate.back.service.implimentation;

import org.springframework.stereotype.Service;

import com.estate.back.repository.EstateRepository;
import com.estate.back.service.EstateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstateServiceImplimentation implements EstateService {
    
    private final EstateRepository estateRepository;
}
