package com.cnu.motion.Exam;

import com.cnu.motion.Exam.ExamService;
import com.cnu.motion.DTO.ExamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    ExamService examService;

    @GetMapping("/detail/{exam-id}")
    public ExamDTO getDetailByExamId(@PathVariable("exam-id") String id){
        ExamDTO exam = new ExamDTO();
        exam.setExamId(id);
        return examService.getDetailByExamId(exam);
    }
}
