package work.hochguertel.salonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties(SalonDetails.class)
public class SalonApiApplication {

    @Autowired
    public SalonApiApplication(
            final SalonDetails salonDetails,
            final SalonRepository salonRepository
    ) {
        Salon salon = salonRepository.findById(1L).orElse(new Salon(
                null,
                salonDetails.getName(),
                salonDetails.getAddress(),
                salonDetails.getCity(),
                salonDetails.getState(),
                salonDetails.getZipcode(),
                salonDetails.getPhone()
        ));
        var save = salonRepository.save(salon);
    }

    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/**").allowedOrigins("*");
            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalonApiApplication.class, args);
    }

}
