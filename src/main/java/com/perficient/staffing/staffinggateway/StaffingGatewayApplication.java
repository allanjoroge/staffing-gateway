package com.perficient.staffing.staffinggateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.perficient.staffing") //scan base packages connects it to the local thing.
public class StaffingGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffingGatewayApplication.class, args);
    }

}
