package org.rcfactory.rcfactoryeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RcfactoryEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RcfactoryEurekaServiceApplication.class, args);
    }

}
