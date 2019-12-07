package com.cnu.motion.Schedule;

import com.cnu.motion.DTO.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping
    public int addNewSchedule(@RequestBody ScheduleDTO schedule) {
        int storedIndex = -1;
        try {
            storedIndex = scheduleService.addNewSchedule(schedule);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return storedIndex;
    }
}
