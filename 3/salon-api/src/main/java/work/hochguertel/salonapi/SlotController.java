package work.hochguertel.salonapi;

import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController()
@RequestMapping("/api/services")
public class SlotController {

    private final Logger logger = LoggerFactory.getLogger(SlotController.class);
    private final SlotRepository slotRepository;
    private final SlotMapper slotMapper;

    public SlotController(
            SlotRepository slotRepository,
            SlotMapper slotMapper
    ) {
        this.slotRepository = slotRepository;
        this.slotMapper = slotMapper;
    }


    @RequestMapping(value = "/retrieveAvailableSlots/{salonServiceId}/{formattedDate}", method = RequestMethod.GET)
    public List<SlotDto> retrieveAvailableSlots(
            @PathVariable("salonServiceId") Long salonServiceId,
            @Parameter(name = "formattedDate", description = "Date in yyyy-MM-dd format", example = "2024-03-11") @PathVariable("formattedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate formattedDate
    ) {
        logger.info("retrieveAvailableSlots");

        LocalDateTime start = LocalDateTime.of(formattedDate, LocalTime.of(0, 0, 0));
        LocalDateTime end = LocalDateTime.of(formattedDate, LocalTime.of(19, 0, 0));

        List<Slot> allSlots = slotRepository.findByStatusAndSlotForBetweenAndAvailableServices_Id(SlotStatus.AVAILABLE, start, end, salonServiceId);

        return slotMapper.map(allSlots);
    }
}
