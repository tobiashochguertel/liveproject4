package work.hochguertel.salonapi;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface SlotMapper {

    SlotDto map(Slot entity);

    List<SlotDto> map(List<Slot> entities);

}
