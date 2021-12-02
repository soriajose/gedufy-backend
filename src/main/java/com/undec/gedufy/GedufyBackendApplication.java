package com.undec.gedufy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
        GedufyBackendApplication.class,
        Jsr310JpaConverters.class
})
@EnableScheduling
@ServletComponentScan
public class GedufyBackendApplication extends SpringBootServletInitializer {

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
    }

    public static void main(String[] args) {
        SpringApplication.run(GedufyBackendApplication.class, args);
    }

}
