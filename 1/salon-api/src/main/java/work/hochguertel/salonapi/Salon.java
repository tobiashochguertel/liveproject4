package work.hochguertel.salonapi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
create table public.salons (
        name character varying not null,
        address character varying not null,
        city character varying not null,
        state character varying not null,
        zipcode character varying not null,
        phone character varying not null,
        id bigint primary key not null
);
*/
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String city;

    private String state;

    private String zipcode;

    private String phone;

}
