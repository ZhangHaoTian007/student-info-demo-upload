package com.demo;

import com.demo.domain.Account;
import com.demo.persitence.AccountRepository;
import com.demo.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentInfoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentInfoDemoApplication.class, args);
    }



    CommandLineRunner createAdmin(AccountService accountService) {
        return args -> {
            Account account = new Account("admin", "990415", 0, null);
            accountService.register(account);
        };
    }
}
