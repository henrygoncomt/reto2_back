/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo3.repository.crud;

import co.edu.usa.ciclo3.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hgc68
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    @Query("{email:?0}")
    Optional<User> findByEmail(String email);
    @Query("{email:?0, password:?1}")
    Optional<User> findByEmailAndPassword(String email,String password);
    
}
