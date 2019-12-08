package com.cnu.motion.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduleDTO {
    int id;
    String calendarId;
    String title;
    String location;
    String state;
    Date start;
    Date end;
}
