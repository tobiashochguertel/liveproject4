package work.hochguertel.salonapi;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface SalonServiceDetailMapper {

    List<SalonServiceDetailDto> map(List<SalonServiceDetail> entities);

    SalonServiceDetailDto map(SalonServiceDetail entity);

}