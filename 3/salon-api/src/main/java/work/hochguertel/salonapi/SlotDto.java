package work.hochguertel.salonapi;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SlotDto {

    LocalDateTime confirmedAt;
    private Long id;
    LocalDateTime lockedAt;
    private SalonServiceDetailDto selectedService;
    LocalDateTime slotFor;
    private SlotStatus status;
    String stylistName;

}