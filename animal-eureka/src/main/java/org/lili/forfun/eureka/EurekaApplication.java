package org.lili.forfun.eureka;

import com.netflix.eureka.resources.StatusResource;
import com.netflix.eureka.util.StatusInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@Configuration
@EnableEurekaServer
@RestController
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

    @RequestMapping("/status-info")
    public Object statusInfo() {
        StatusInfo statusInfo = null;
        try {
            statusInfo = (new StatusResource()).getStatusInfo();
        } catch (Exception e) {
            statusInfo = StatusInfo.Builder.newBuilder().isHealthy(false).build();
        }
        return statusInfo;
    }
}
