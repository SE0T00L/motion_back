package com.cnu.motion.Exam;

import com.cnu.motion.DTO.ExamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/{grade}/{subject}/{professor}/{midOrFinal}/{offset}/{limit}")
    public List<ExamDTO> getDetailList(@PathVariable("grade") int grade, @PathVariable(value = "subject", required = false) String subject, @PathVariable(value = "professor", required = false) String professor
        , @PathVariable("midOrFinal") int midOrFinal, @PathVariable("offset") int offset, @PathVariable("limit") int limit){
        ExamDTO exam = new ExamDTO();
        exam.setGrade(grade);
        exam.setName(subject);
        exam.setProfessor(professor);
        exam.setMidOrFinal(midOrFinal);
        offset = (offset-1)*limit;
        exam.setOffset(offset);
        exam.setLimit(limit);

        return examService.getDetailList(exam);
    }
}
