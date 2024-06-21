package com.cabbooking.service;

import com.cabbooking.model.Cab;
import com.cabbooking.repository.CabRepository;

import java.util.List;

public class CabService {
    private CabRepository cabRepository = new CabRepository();

    public void registerCab(Cab cab) {
        cabRepository.save(cab);
    }

    public List<Cab> listCabs() {
        return cabRepository.findAll();
    }

    public List<Cab> getCabs() {
        // For simplicity, return all cabs
        return cabRepository.findAll();
    }
}
