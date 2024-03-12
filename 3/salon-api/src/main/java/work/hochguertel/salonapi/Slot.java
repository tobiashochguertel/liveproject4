package work.hochguertel.salonapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Slot {

    @Transient
    private final Logger logger = LoggerFactory.getLogger(Slot.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    Set<SalonServiceDetail> availableServices;

    @ManyToOne
    private SalonServiceDetail selectedService;

    String stylistName;

    LocalDateTime slotFor;

    private SlotStatus status;

    LocalDateTime lockedAt;

    LocalDateTime confirmedAt;

}

enum SlotStatus {
    AVAILABLE, LOCKED, CONFIRMED, CANCELLED
}