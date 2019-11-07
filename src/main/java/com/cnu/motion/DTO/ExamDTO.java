package com.cnu.motion.DTO;

import lombok.Data;

@Data
public class ExamDTO {
    private String classification;
    private String examId;
    private int grade;
    private String subjectName;
    private int midOrFinal;
    private String examDate;
    private String userId;
    private String registerDate;
}
