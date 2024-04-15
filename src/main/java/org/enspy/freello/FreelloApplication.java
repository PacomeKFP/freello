package org.enspy.freello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreelloApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FreelloApplication.class, args);
    }

    @Override
    public void run(String... args){
        System.out.println("Pavel Tieuguim vous salut ");
    }
}
