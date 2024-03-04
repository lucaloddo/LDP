package it.unimib.easydefence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EasydefenceApplication {


    public static void main(String[] args) {
        SpringApplication.run(EasydefenceApplication.class, args);
    }

}
