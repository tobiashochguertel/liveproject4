package work.hochguertel.salonapi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "salons")
public class Salon {

    @Transient
    private final Logger logger = LoggerFactory.getLogger(Salon.class);

    @Id
    private Long id;

    private String name;

    private String address;

    private String city;

    private String state;

    private String zipcode;

    private String phone;

}
