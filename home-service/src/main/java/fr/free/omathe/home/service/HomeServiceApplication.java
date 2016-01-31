package fr.free.omathe.home.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("fr.kerlink.iot.model.dao")
@EntityScan("fr.kerlink.iot.model")
@Profile(value = {"dev", "test"})
public class HomeServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(HomeServiceApplication.class, args);
    }
    
    @Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/iot-service-messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
