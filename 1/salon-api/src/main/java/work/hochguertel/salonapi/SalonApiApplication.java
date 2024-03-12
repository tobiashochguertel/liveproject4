package work.hochguertel.salonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

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


    public static void main(String[] args) {
        SpringApplication.run(SalonApiApplication.class, args);
    }

}
