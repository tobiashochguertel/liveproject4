package work.hochguertel.salonapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    List<Slot> findByStatus(@NonNull SlotStatus status);

    List<Slot> findByStatusAndSelectedService_IdAndSlotFor(@NonNull SlotStatus status, @NonNull Long id, @NonNull LocalDateTime slotFor);

    List<Slot> findByStatusAndSlotFor(@NonNull SlotStatus status, @NonNull LocalDateTime slotFor);

    List<Slot> findByStatusAndSlotForGreaterThan(@NonNull SlotStatus status, @NonNull LocalDateTime slotFor);

    List<Slot> findByStatusAndSlotForBetweenAndAvailableServices_Id(@NonNull SlotStatus status, @NonNull LocalDateTime slotForStart, @NonNull LocalDateTime slotForEnd, @NonNull Long id);
}
