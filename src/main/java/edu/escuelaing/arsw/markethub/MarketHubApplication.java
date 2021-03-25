package edu.escuelaing.arsw.markethub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.escuelaing.arsw.markethub.persistence.impl.MockPersistence;

@SpringBootApplication
public class MarketHubApplication implements CommandLineRunner {

    @Autowired
    MockPersistence mp;

    public static void main(String[] args) {
        SpringApplication.run(MarketHubApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Este método está intencionalmente en blanco
        mp.insert();
    }

}