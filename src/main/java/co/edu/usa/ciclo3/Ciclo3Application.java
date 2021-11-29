package co.edu.usa.ciclo3;

import co.edu.usa.ciclo3.modelo.Administrador;
import co.edu.usa.ciclo3.modelo.User;
import co.edu.usa.ciclo3.repository.AdministradorRepository;
import co.edu.usa.ciclo3.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@EntityScan(basePackages = {"co.edu.usa.ciclo3.modelo"})
@SpringBootApplication
public class Ciclo3Application {
        @Autowired
        private AdministradorRepository administradorCrudRepository;
        @Autowired
        private UserRepository userCrudRepository;
        
	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}
        
        @Bean
        ApplicationRunner applicationRunner() {
            return args -> {
                
                  
            };
        }

}
