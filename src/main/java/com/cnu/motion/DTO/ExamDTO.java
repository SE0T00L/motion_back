package com.cnu.motion.DTO;

import lombok.Data;

@Data
public class ExamDTO {
    private String classification;
    private String examId;
    private int grade;
    private int subjectId;
    private int midOrFinal;
    private String examYear;
    private String userId;
    private String registerDate;

    private String professor;
    private String name;
    private int offset;
    private int limit;
}
