package edu.escuelaing.arsw.markethub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketHubApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MarketHubApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Este método está intencionalmente en blanco
    }
}