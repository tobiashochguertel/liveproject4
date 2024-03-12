package work.hochguertel.salonapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/services")
public class SalonServiceDetailsController {

    private final Logger logger = LoggerFactory.getLogger(SalonServiceDetailsController.class);
    private final SalonServiceDetailRepository salonServiceDetailRepository;
    private final SalonServiceDetailMapper salonServiceDetailMapper;


    @Autowired
    public SalonServiceDetailsController(
            SalonServiceDetailRepository salonServiceDetailRepository,
            SalonServiceDetailMapper salonServiceDetailMapper
    ) {
        this.salonServiceDetailRepository = salonServiceDetailRepository;
        this.salonServiceDetailMapper = salonServiceDetailMapper;
    }

    @RequestMapping(value = "/retrieveAvailableSalonServices", method = RequestMethod.GET)
    public List<SalonServiceDetailDto> retrieveAvailableSalonServices() {
        logger.info("retrieveAvailableSalonServices");

        List<SalonServiceDetail> allServices = salonServiceDetailRepository.findAll();

        return salonServiceDetailMapper.map(allServices);
    }
}
