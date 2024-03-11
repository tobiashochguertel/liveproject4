package work.hochguertel.salonapi;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "salon")
@Data
public class SalonDetails {

    private final Logger logger = LoggerFactory.getLogger(SalonDetails.class);

    private String name;

    private String address;

    private String city;

    private String state;

    private String zipcode;

    private String phone;

}
