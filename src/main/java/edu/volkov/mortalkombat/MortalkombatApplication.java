package edu.volkov.mortalkombat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MortalkombatApplication {

    public static void main(String[] args) {
        SpringApplication.run(MortalkombatApplication.class, args);
    }

}
