package com.cnu.motion.Schedule;

import com.cnu.motion.DTO.ScheduleDTO;
import com.cnu.motion.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleMapper scheduleMapper;

    public int addNewSchedule(ScheduleDTO schedule) {
        return scheduleMapper.addNewSchedule(schedule);
    }

    public List<ScheduleDTO> getAllSchedule() {
        return scheduleMapper.getAllSchedule();
    }

    public boolean updateSchedule(ScheduleDTO schedule) {
        return scheduleMapper.updateSchedule(schedule);
    }

    public boolean deleteSchedule(ScheduleDTO schedule) {
        return scheduleMapper.deleteSchedule(schedule);
    }
}
