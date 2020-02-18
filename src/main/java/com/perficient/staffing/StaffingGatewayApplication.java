package com.perficient.staffing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StaffingGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffingGatewayApplication.class, args);
    }

}
