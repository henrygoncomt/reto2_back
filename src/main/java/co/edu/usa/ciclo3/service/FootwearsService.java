/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo3.service;

import co.edu.usa.ciclo3.modelo.Footwears;
import co.edu.usa.ciclo3.repository.FootwearsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hgc68
 */
@Service
public class FootwearsService {
     @Autowired
    private FootwearsRepository clotheRepository;

    public List<Footwears> getAll() {
        return clotheRepository.getAll();
    }

   public Optional<Footwears> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Footwears create(Footwears accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Footwears update(Footwears accesory) {

        if (accesory.getReference() != null) {
            Optional<Footwears> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (accesoryDb.isPresent()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getMaterial() != null) {
                    accesoryDb.get().setMaterial(accesory.getMaterial());
                }
                if (accesory.getGender() != null) {
                    accesoryDb.get().setGender(accesory.getGender());
                }
                if (accesory.getSize() != null) {
                    accesoryDb.get().setSize(accesory.getSize());
                }
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
