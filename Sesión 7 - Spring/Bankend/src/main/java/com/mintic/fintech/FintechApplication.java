package com.mintic.fintech;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FintechApplication implements CommandLineRunner{
            
	public static void main(String[] args) {
		SpringApplication.run(FintechApplication.class, args);
	}

        
    @Override
    public void run(String... args) throws Exception {
        System.out.println("");
        System.out.println("********************************");
        System.out.println("**** Inicio la aplicación ******");
        System.out.println("");
    }

}
