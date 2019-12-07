package com.cnu.motion.Schedule;

import com.cnu.motion.DTO.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<ScheduleDTO> getAllSchedule() {
        return scheduleService.getAllSchedule();
    }

    @PutMapping
    public boolean updateSchedule(@RequestBody ScheduleDTO schedule) {
        try {
            scheduleService.updateSchedule(schedule);
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }
}
