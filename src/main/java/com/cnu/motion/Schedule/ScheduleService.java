package com.cnu.motion.Schedule;

import com.cnu.motion.DTO.ScheduleDTO;
import com.cnu.motion.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleMapper scheduleMapper;

    public int addNewSchedule(ScheduleDTO schedule) {
        return scheduleMapper.addNewSchedule(schedule);
    }
}
