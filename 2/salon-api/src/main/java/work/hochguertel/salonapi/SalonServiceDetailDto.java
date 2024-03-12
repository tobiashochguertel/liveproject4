package work.hochguertel.salonapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalonServiceDetailDto {

    Long id;
    String name;
    String description;
    Long price;
    Integer timeInMinutes;
    
}
