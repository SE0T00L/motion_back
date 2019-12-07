package com.cnu.motion.mapper;

import com.cnu.motion.DTO.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScheduleMapper {
    int addNewSchedule(ScheduleDTO schedule);
    List<ScheduleDTO> getAllSchedule();
    boolean updateSchedule(ScheduleDTO schedule);
}
