package com.aqqje.actuator.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicators implements HealthIndicator {

    @Override
    public Health health() {
        //return Health.up().build();
        return Health.down().withDetail("msg","服务异常").build();
    }
}
