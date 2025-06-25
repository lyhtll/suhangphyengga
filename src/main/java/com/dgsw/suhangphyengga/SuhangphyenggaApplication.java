package com.dgsw.suhangphyengga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SuhangphyenggaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuhangphyenggaApplication.class, args);
    }

}
