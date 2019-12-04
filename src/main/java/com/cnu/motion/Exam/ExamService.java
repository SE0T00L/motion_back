package com.cnu.motion.Exam;

import com.cnu.motion.DTO.ExamDTO;
import com.cnu.motion.mapper.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    @Autowired
    ExamMapper examMapper;

    public ExamDTO getDetailByExamId(ExamDTO exam) {
        return examMapper.getDetailByExamId(exam);
    }
    public List<ExamDTO> getDetailList(ExamDTO exam) {
        return examMapper.getDetailList(exam);
    }
}
