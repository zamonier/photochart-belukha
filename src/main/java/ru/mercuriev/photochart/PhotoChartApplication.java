package ru.mercuriev.photochart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableScheduling
@EnableWebMvc
public class PhotoChartApplication extends WebMvcAutoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(PhotoChartApplication.class, args);
    }
}
