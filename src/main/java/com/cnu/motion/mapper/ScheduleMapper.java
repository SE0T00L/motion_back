package com.cnu.motion.mapper;

import com.cnu.motion.DTO.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ScheduleMapper {
    int addNewSchedule(ScheduleDTO schedule);
}
