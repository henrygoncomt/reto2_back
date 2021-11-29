/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo3.repository;

import co.edu.usa.ciclo3.modelo.Footwears;
import co.edu.usa.ciclo3.repository.crud.FootwearsCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hgc68
 */
@Repository
public class FootwearsRepository {
    @Autowired
    private FootwearsCrudRepository repository;

    public List<Footwears> getAll() {
        return repository.findAll();
    }

    public Optional<Footwears> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Footwears create(Footwears clothe) {
        return repository.save(clothe);
    }

    public void update(Footwears clothe) {
        repository.save(clothe);
    }
    
    public void delete(Footwears clothe) {
        repository.delete(clothe);
    }
}


